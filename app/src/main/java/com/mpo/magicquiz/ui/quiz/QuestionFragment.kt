package com.mpo.magicquiz.ui.quiz

import android.content.Intent
import android.net.Uri
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
import com.mpo.magicquiz.ads.BannerAdManager
import com.mpo.magicquiz.ads.InterstitialAdManager
import com.mpo.magicquiz.ads.RewardedAdManager
import com.mpo.magicquiz.databinding.FragmentQuestionBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuestionFragment : Fragment() {
    private var _binding: FragmentQuestionBinding? = null
    private val binding get() = _binding!!
    private lateinit var answerFeedbackOverlay: AnswerFeedbackOverlay
    private lateinit var viewModel: QuestionViewModel
    private lateinit var rewardedAdManager: RewardedAdManager
    private lateinit var bannerAdManager: BannerAdManager
    private lateinit var interstitialAdManager: InterstitialAdManager
    private var hintUsed = false
    private var questionsSinceLastInterstitial = 0
    private var hasShownLowScoreAd = false

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
        rewardedAdManager = RewardedAdManager(requireContext())
        bannerAdManager = BannerAdManager(requireContext())
        interstitialAdManager = InterstitialAdManager(requireContext())

        setupQuestionObservers()
        setupAnswerButtons()
        setupHintButton()
        setupRatingButton()
        loadBannerAd()
    }

    private fun loadBannerAd() {
        bannerAdManager.loadBannerAd(binding.adView)
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

            // Reset hint state for new question
            hintUsed = false
            binding.hintContainer.visibility = View.GONE
            binding.buttonHint.isEnabled = true
        }

        viewModel.currentLevel.observe(viewLifecycleOwner) { level ->
            binding.textLevel.text = "Level $level"
        }

        viewModel.score.observe(viewLifecycleOwner) { score ->
            // Show interstitial ad if score is less than 15 and we haven't shown the low score ad yet
            if (score < 15 && !hasShownLowScoreAd) {
                showInterstitialAd {
                    hasShownLowScoreAd = true
                }
            }
        }

        viewModel.isTransitioning.observe(viewLifecycleOwner) { isTransitioning ->
            binding.root.isEnabled = !isTransitioning
        }
    }

    private fun setupHintButton() {
        binding.buttonHint.setOnClickListener {
            if (!hintUsed) {
                // Show ad before revealing hint
                rewardedAdManager.showRewardedAd(requireActivity()) {
                    // This callback is called when the user earns the reward
                    val question = viewModel.currentQuestion.value
                    question?.let {
                        binding.textHint.text = "💡 Hint: ${it.hint}"
                        binding.hintContainer.visibility = View.VISIBLE
                        binding.buttonHint.isEnabled = false
                        hintUsed = true
                    }
                }
            }
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
                questionsSinceLastInterstitial++
                if (questionsSinceLastInterstitial >= 15) {
                    showInterstitialAd {
                        viewModel.moveToNextQuestion()
                    }
                    questionsSinceLastInterstitial = 0
                } else {
                    viewModel.moveToNextQuestion()
                }
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
                questionsSinceLastInterstitial++
                if (questionsSinceLastInterstitial >= 15) {
                    showInterstitialAd {
                        viewModel.moveToNextQuestion()
                    }
                    questionsSinceLastInterstitial = 0
                } else {
                    viewModel.moveToNextQuestion()
                }
            } else {
                // Navigate to results screen
                val action = QuestionFragmentDirections.actionQuestionFragmentToResultFragment(
                    viewModel.score.value ?: 0
                )
                findNavController().navigate(action)
            }
        }
    }

    private fun showInterstitialAd(onAdDismissed: () -> Unit) {
        interstitialAdManager.showInterstitialAd(onAdDismissed)
    }

    private fun setupRatingButton() {
        binding.buttonRate.setOnClickListener {
            try {
                // Open Play Store rating page
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("market://details?id=${requireContext().packageName}")
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                startActivity(intent)
            } catch (e: Exception) {
                // If Play Store app is not installed, open in browser
                val intent = Intent(Intent.ACTION_VIEW).apply {
                    data = Uri.parse("https://play.google.com/store/apps/details?id=${requireContext().packageName}")
                }
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 