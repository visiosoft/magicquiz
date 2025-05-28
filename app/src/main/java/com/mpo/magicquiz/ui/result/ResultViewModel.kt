package com.mpo.magicquiz.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ResultViewModel(private val finalScore: Int) : ViewModel() {
    val scoreText: String
        get() = "Your Score: $finalScore/25"

    class Factory(private val finalScore: Int) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ResultViewModel::class.java)) {
                return ResultViewModel(finalScore) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
} 