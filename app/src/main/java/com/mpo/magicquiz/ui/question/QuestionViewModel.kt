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
        loadQuestionsForLevel(level)
        loadInterstitialAd()
    }

    private fun loadQuestionsForLevel(level: Int) {
        currentQuestions = when (level) {
            1 -> Questions.level1Questions
            2 -> Questions.level2Questions
            3 -> Questions.level3Questions
            else -> Questions.level1Questions
        }
        _totalQuestions.value = currentQuestions.size
        loadQuestion(0)
    }

    fun loadQuestion(index: Int) {
        if (index < currentQuestions.size) {
            currentQuestionIndex = index
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
        
        // Check if score meets threshold for unlocking next level
        if (currentScore >= 15) {
            when (currentLevel) {
                1 -> levelManager.unlockLevel(2)
                2 -> levelManager.unlockLevel(3)
            }
        }
        
        _feedback.value = when {
            currentScore < 10 -> "Level Failed! Score: $currentScore/$totalQuestions"
            currentScore < 15 -> "Average Performance! Score: $currentScore/$totalQuestions"
            else -> "Congratulations! Excellent Score: $currentScore/$totalQuestions"
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
            when {
                question.question.contains("capital", ignoreCase = true) -> 
                    "Think about the main city of the country"
                question.question.contains("largest", ignoreCase = true) -> 
                    "Consider which option represents the biggest or most significant"
                question.question.contains("smallest", ignoreCase = true) -> 
                    "Consider which option represents the least significant"
                question.question.contains("planet", ignoreCase = true) -> 
                    "Think about the unique characteristics of each planet"
                question.question.contains("animal", ignoreCase = true) -> 
                    "Consider the natural habitat and characteristics of each animal"
                question.question.contains("ocean", ignoreCase = true) -> 
                    "Think about the size and location of each ocean"
                question.question.contains("mountain", ignoreCase = true) -> 
                    "Consider the height and location of each mountain"
                question.question.contains("river", ignoreCase = true) -> 
                    "Think about the length and flow of each river"
                question.question.contains("desert", ignoreCase = true) -> 
                    "Consider the size and climate of each desert"
                question.question.contains("country", ignoreCase = true) -> 
                    "Think about the geographical location and characteristics"
                question.question.contains("element", ignoreCase = true) -> 
                    "Consider the periodic table and element properties"
                question.question.contains("invention", ignoreCase = true) -> 
                    "Think about the historical context and impact"
                question.question.contains("discovery", ignoreCase = true) -> 
                    "Consider the time period and significance"
                question.question.contains("scientist", ignoreCase = true) -> 
                    "Think about their major contributions and field of study"
                question.question.contains("language", ignoreCase = true) -> 
                    "Consider the number of speakers and geographical distribution"
                question.question.contains("color", ignoreCase = true) -> 
                    "Think about the primary colors and their combinations"
                question.question.contains("number", ignoreCase = true) -> 
                    "Consider mathematical properties and relationships"
                question.question.contains("shape", ignoreCase = true) -> 
                    "Think about geometric properties and dimensions"
                question.question.contains("food", ignoreCase = true) -> 
                    "Consider the origin and main ingredients"
                question.question.contains("sport", ignoreCase = true) -> 
                    "Think about the rules and equipment used"
                question.question.contains("music", ignoreCase = true) -> 
                    "Consider the genre and historical period"
                question.question.contains("book", ignoreCase = true) -> 
                    "Think about the author and publication date"
                question.question.contains("movie", ignoreCase = true) -> 
                    "Consider the director and release year"
                question.question.contains("artist", ignoreCase = true) -> 
                    "Think about their style and famous works"
                else -> "Look for clues in the question that might help identify the correct answer"
            }
        } ?: "No hint available"
    }
} 