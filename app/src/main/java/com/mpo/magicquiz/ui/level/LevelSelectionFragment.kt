package com.mpo.magicquiz.ui.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mpo.magicquiz.R
import com.mpo.magicquiz.data.LevelManager
import com.mpo.magicquiz.databinding.FragmentLevelSelectionBinding

class LevelSelectionFragment : Fragment() {
    private var _binding: FragmentLevelSelectionBinding? = null
    private val binding get() = _binding!!
    private lateinit var levelManager: LevelManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLevelSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        levelManager = LevelManager(requireContext())

        setupLevelButtons()
    }

    private fun setupLevelButtons() {
        // Level 1 is always unlocked
        binding.level1Button.setOnClickListener {
            navigateToQuestion(1)
        }

        // Level 2
        if (levelManager.isLevelUnlocked(2)) {
            binding.level2Button.isEnabled = true
            binding.level2Button.setOnClickListener {
                navigateToQuestion(2)
            }
        } else {
            binding.level2Button.isEnabled = false
            binding.level2Button.text = "Level 2 (Locked)"
            binding.level2Button.setOnClickListener {
                Toast.makeText(context, "Complete Level 1 with 15+ score to unlock", Toast.LENGTH_SHORT).show()
            }
        }

        // Level 3
        if (levelManager.isLevelUnlocked(3)) {
            binding.level3Button.isEnabled = true
            binding.level3Button.setOnClickListener {
                navigateToQuestion(3)
            }
        } else {
            binding.level3Button.isEnabled = false
            binding.level3Button.text = "Level 3 (Locked)"
            binding.level3Button.setOnClickListener {
                Toast.makeText(context, "Complete Level 2 with 15+ score to unlock", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToQuestion(level: Int) {
        val action = LevelSelectionFragmentDirections.actionLevelSelectionToQuestion(level)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
} 