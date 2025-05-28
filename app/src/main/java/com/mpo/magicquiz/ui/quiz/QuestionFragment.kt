package com.mpo.magicquiz.ui.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.button.MaterialButton
import com.mpo.magicquiz.R
import com.mpo.magicquiz.databinding.FragmentQuestionBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private lateinit var answerFeedbackOverlay: AnswerFeedbackOverlay
    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuestionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        viewModel = ViewModelProvider(this)[QuestionViewModel::class.java]
        answerFeedbackOverlay = AnswerFeedbackOverlay(requireContext(), binding.root as ViewGroup)

        setupQuestionObservers()
        setupAnswerButtons()
    }

    private fun setupQuestionObservers() {
        viewModel.currentQuestion.observe(viewLifecycleOwner) { question ->
            binding.textQuestion.text = question.text
            binding.textQuestionNumber.text = "Question ${viewModel.getCurrentQuestionNumber()}"
            binding.textProgress.text = "${viewModel.getCurrentQuestionNumber()}/${viewModel.getTotalQuestions()}"
            
            // Update progress bar
            val progress = (viewModel.getCurrentQuestionNumber().toFloat() / viewModel.getTotalQuestions()) * 100
            binding.progressIndicator.setProgress(progress.toInt(), true)
            
            // Update answer buttons
            question.options.forEachIndexed { index, option ->
                (binding.answerContainer.getChildAt(index) as? MaterialButton)?.apply {
                    text = option
                    isEnabled = true
                    alpha = 1f
                }
            }
        }

        viewModel.currentLevel.observe(viewLifecycleOwner) { level ->
            binding.textLevel.text = "Level $level"
        }

        viewModel.isTransitioning.observe(viewLifecycleOwner) { isTransitioning ->
            binding.root.isEnabled = !isTransitioning
        }
    }

    private fun setupAnswerButtons() {
        for (i in 0 until binding.answerContainer.childCount) {
            (binding.answerContainer.getChildAt(i) as? MaterialButton)?.setOnClickListener { button ->
                val selectedIndex = binding.answerContainer.indexOfChild(button)
                handleAnswerSelection(selectedIndex)
            }
        }
    }

    private fun handleAnswerSelection(selectedIndex: Int) {
        // Disable all buttons
        for (i in 0 until binding.answerContainer.childCount) {
            (binding.answerContainer.getChildAt(i) as? MaterialButton)?.isEnabled = false
        }

        val question = viewModel.currentQuestion.value ?: return
        viewModel.checkAnswer(selectedIndex)

        if (selectedIndex == question.correctAnswerIndex) {
            showCorrectAnswerFeedback()
        } else {
            showWrongAnswerFeedback()
        }
    }

    private fun showCorrectAnswerFeedback() {
        answerFeedbackOverlay.showCorrectAnswer {
            if (!viewModel.isLastQuestion()) {
                viewModel.moveToNextQuestion()
            } else {
                // Navigate to results screen
                val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
                    viewModel.score.value ?: 0
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun showWrongAnswerFeedback() {
        answerFeedbackOverlay.showWrongAnswer {
            if (!viewModel.isLastQuestion()) {
                viewModel.moveToNextQuestion()
            } else {
                // Navigate to results screen
                val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
                    viewModel.score.value ?: 0
                )
                findNavController().navigate(action)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 