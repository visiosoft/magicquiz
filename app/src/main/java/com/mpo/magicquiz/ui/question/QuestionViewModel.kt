package com.mpo.magicquiz.ui.question

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.mpo.magicquiz.Question
import com.mpo.magicquiz.Questions
import com.mpo.magicquiz.data.LevelManager
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    private val levelManager = LevelManager(application)
    private var interstitialAd: InterstitialAd? = null
    
    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _level = MutableLiveData<Int>()
    val level: LiveData<Int> = _level

    private val _questionNumber = MutableLiveData<Int>()
    val questionNumber: LiveData<Int> = _questionNumber

    private val _totalQuestions = MutableLiveData<Int>()
    val totalQuestions: LiveData<Int> = _totalQuestions

    private val _feedback = MutableLiveData<String>()
    val feedback: LiveData<String> = _feedback

    private val _isLevelComplete = MutableLiveData<Boolean>()
    val isLevelComplete: LiveData<Boolean> = _isLevelComplete

    private val _showInterstitial = MutableLiveData<Boolean>()
    val showInterstitial: LiveData<Boolean> = _showInterstitial

    private var currentQuestions: List<Question> = emptyList()
    private var currentQuestionIndex = 0
    private var currentHintIndex = 0

    init {
        _score.value = 0
        _level.value = 1
        _questionNumber.value = 1
        _isLevelComplete.value = false
        _showInterstitial.value = false
        loadQuestionsForLevel(1)
        loadInterstitialAd()
    }

    fun setLevel(level: Int) {
        _level.value = level
        _score.value = 0
        _questionNumber.value = 1
        _isLevelComplete.value = false
        _showInterstitial.value = false
        currentHintIndex = 0
        loadQuestionsForLevel(level)
        loadInterstitialAd()
    }

    private fun loadQuestionsForLevel(level: Int) {
        currentQuestions = when (level) {
            1 -> Questions.level1Questions
            2 -> Questions.level2Questions
            3 -> Questions.level3Questions
            4 -> Questions.level4Questions
            5 -> Questions.level5Questions
            else -> Questions.level1Questions
        }
        _totalQuestions.value = currentQuestions.size
        loadQuestion(0)
    }

    fun loadQuestion(index: Int) {
        if (index < currentQuestions.size) {
            currentQuestionIndex = index
            currentHintIndex = 0
            _currentQuestion.value = currentQuestions[index]
            _questionNumber.value = index + 1
        } else {
            checkLevelCompletion()
        }
    }

    fun checkAnswer(selectedAnswer: Int): Boolean {
        val question = _currentQuestion.value
        return if (question != null) {
            val isCorrect = selectedAnswer == question.correctAnswer
            if (isCorrect) {
                _score.value = (_score.value ?: 0) + 1
            }
            isCorrect
        } else {
            false
        }
    }

    fun nextQuestion() {
        if (currentQuestionIndex + 1 < currentQuestions.size) {
            loadQuestion(currentQuestionIndex + 1)
        } else {
            checkLevelCompletion()
        }
    }

    private fun checkLevelCompletion() {
        _isLevelComplete.value = true
        val currentScore = _score.value ?: 0
        val totalQuestions = currentQuestions.size
        val currentLevel = _level.value ?: 1
        
        // Save the level score
        levelManager.saveLevelScore(currentLevel, currentScore)
        
        // Check if next level should be unlocked
        val nextLevel = currentLevel + 1
        if (nextLevel <= 5 && levelManager.isLevelUnlocked(nextLevel)) {
            _feedback.value = "Congratulations! Level $nextLevel unlocked! Score: $currentScore/$totalQuestions"
        } else {
            _feedback.value = when {
                currentScore < 10 -> "Level Failed! Score: $currentScore/$totalQuestions"
                currentScore < 15 -> "Average Performance! Score: $currentScore/$totalQuestions"
                else -> "Congratulations! Excellent Score: $currentScore/$totalQuestions"
            }
        }

        // Show interstitial ad
        _showInterstitial.value = true
    }

    private fun loadInterstitialAd() {
        val adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            getApplication(),
            "ca-app-pub-3940256099942544/1033173712", // Test ad unit ID
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(ad: InterstitialAd) {
                    interstitialAd = ad
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    interstitialAd = null
                }
            }
        )
    }

    fun getInterstitialAd(): InterstitialAd? {
        return interstitialAd
    }

    fun resetInterstitialFlag() {
        _showInterstitial.value = false
    }

    fun getHint(): String {
        return _currentQuestion.value?.let { question ->
            if (question.hints.isNotEmpty()) {
                val hint = question.hints[currentHintIndex % question.hints.size]
                currentHintIndex++
                hint
            } else {
                "No hint available"
            }
        } ?: "No hint available"
    }

    fun getCurrentHintIndex(): Int {
        return currentHintIndex
    }
} 