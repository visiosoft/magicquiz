package com.mpo.magicquiz.ui.level

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
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

    override fun onResume() {
        super.onResume()
        // Refresh level buttons in case scores have changed
        setupLevelButtons()
    }

    private fun setupLevelButtons() {
        // Level 1 is always unlocked
        binding.level1Button.isEnabled = true
        binding.level1Button.setOnClickListener {
            navigateToQuestion(1)
        }

        // Check and setup other levels
        setupLevelButton(2, binding.level2Button, binding.level2LockIcon, binding.level2UnlockMessage)
        setupLevelButton(3, binding.level3Button, binding.level3LockIcon, binding.level3UnlockMessage)
        setupLevelButton(4, binding.level4Button, binding.level4LockIcon, binding.level4UnlockMessage)
        setupLevelButton(5, binding.level5Button, binding.level5LockIcon, binding.level5UnlockMessage)
    }

    private fun setupLevelButton(level: Int, button: com.google.android.material.button.MaterialButton, 
                                lockIcon: android.widget.ImageView, unlockMessage: android.widget.TextView) {
        if (levelManager.isLevelUnlocked(level)) {
            // Level is unlocked
            button.isEnabled = true
            lockIcon.visibility = View.GONE
            unlockMessage.visibility = View.GONE
            button.setOnClickListener {
                navigateToQuestion(level)
            }
        } else {
            // Level is locked
            button.isEnabled = false
            lockIcon.visibility = View.VISIBLE
            unlockMessage.visibility = View.VISIBLE
            unlockMessage.text = levelManager.getUnlockMessage(level)
            button.setOnClickListener {
                Toast.makeText(context, "Complete the previous level first!", Toast.LENGTH_SHORT).show()
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