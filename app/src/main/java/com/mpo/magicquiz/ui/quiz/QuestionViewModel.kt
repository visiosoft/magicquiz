package com.mpo.magicquiz.ui.quiz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

data class Question(
    val id: Int,
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val hint: String
)

class QuestionViewModel : ViewModel() {
    private val _currentQuestion = MutableLiveData<Question>()
    val currentQuestion: LiveData<Question> = _currentQuestion

    private val _isTransitioning = MutableLiveData<Boolean>()
    val isTransitioning: LiveData<Boolean> = _isTransitioning

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int> = _score

    private val _currentLevel = MutableLiveData<Int>()
    val currentLevel: LiveData<Int> = _currentLevel

    private val questions = listOf(
        Question(
            1,
            "What is the capital of France?",
            listOf("London", "Berlin", "Paris", "Madrid"),
            2,
            "It's known as the City of Light"
        ),
        Question(
            2,
            "Which planet is known as the Red Planet?",
            listOf("Venus", "Mars", "Jupiter", "Saturn"),
            1,
            "It's named after the Roman god of war"
        ),
        Question(
            3,
            "What is the largest ocean on Earth?",
            listOf("Atlantic Ocean", "Indian Ocean", "Arctic Ocean", "Pacific Ocean"),
            3,
            "It covers about 30% of Earth's surface"
        ),
        Question(
            4,
            "Who painted the Mona Lisa?",
            listOf("Vincent van Gogh", "Pablo Picasso", "Leonardo da Vinci", "Michelangelo"),
            2,
            "He was also an inventor and scientist"
        ),
        Question(
            5,
            "What is the chemical symbol for gold?",
            listOf("Ag", "Fe", "Au", "Cu"),
            2,
            "It comes from the Latin word 'aurum'"
        ),
        Question(
            6,
            "Which country is home to the kangaroo?",
            listOf("New Zealand", "South Africa", "Australia", "Brazil"),
            2,
            "It's also known as the Land Down Under"
        ),
        Question(
            7,
            "What is the largest mammal in the world?",
            listOf("African Elephant", "Blue Whale", "Giraffe", "Hippopotamus"),
            1,
            "It lives in the ocean and can grow up to 100 feet long"
        ),
        Question(
            8,
            "Who wrote 'Romeo and Juliet'?",
            listOf("Charles Dickens", "William Shakespeare", "Jane Austen", "Mark Twain"),
            1,
            "He's known as the Bard of Avon"
        ),
        Question(
            9,
            "What is the hardest natural substance on Earth?",
            listOf("Platinum", "Diamond", "Quartz", "Titanium"),
            1,
            "It's made of pure carbon"
        ),
        Question(
            10,
            "Which element has the chemical symbol 'O'?",
            listOf("Gold", "Oxygen", "Osmium", "Oganesson"),
            1,
            "It's essential for breathing"
        ),
        Question(
            11,
            "What is the capital of Japan?",
            listOf("Seoul", "Beijing", "Tokyo", "Bangkok"),
            2,
            "It's the world's most populous metropolitan area"
        ),
        Question(
            12,
            "Which planet has the most moons?",
            listOf("Jupiter", "Saturn", "Uranus", "Neptune"),
            1,
            "It's known for its beautiful rings"
        ),
        Question(
            13,
            "What is the largest desert in the world?",
            listOf("Gobi Desert", "Sahara Desert", "Antarctic Desert", "Arabian Desert"),
            2,
            "It's actually covered in ice"
        ),
        Question(
            14,
            "Who discovered penicillin?",
            listOf("Marie Curie", "Alexander Fleming", "Albert Einstein", "Isaac Newton"),
            1,
            "He discovered it by accident in 1928"
        ),
        Question(
            15,
            "What is the smallest country in the world?",
            listOf("Monaco", "San Marino", "Vatican City", "Liechtenstein"),
            2,
            "It's the headquarters of the Catholic Church"
        ),
        Question(
            16,
            "Which animal can change its color?",
            listOf("Chameleon", "Frog", "Snake", "Lizard"),
            0,
            "It has a long, sticky tongue"
        ),
        Question(
            17,
            "What is the capital of Australia?",
            listOf("Sydney", "Melbourne", "Canberra", "Brisbane"),
            2,
            "It's a planned city built specifically to be the capital"
        ),
        Question(
            18,
            "Which planet is closest to the Sun?",
            listOf("Venus", "Mercury", "Mars", "Earth"),
            1,
            "It's the smallest planet in our solar system"
        ),
        Question(
            19,
            "What is the largest organ in the human body?",
            listOf("Heart", "Brain", "Liver", "Skin"),
            3,
            "It protects us from the environment"
        ),
        Question(
            20,
            "Who wrote 'The Theory of Relativity'?",
            listOf("Isaac Newton", "Albert Einstein", "Stephen Hawking", "Galileo Galilei"),
            1,
            "He had wild hair and was known for his equation E=mc²"
        ),
        Question(
            21,
            "What is the currency of Japan?",
            listOf("Won", "Yen", "Ringgit", "Baht"),
            1,
            "Its symbol is ¥"
        ),
        Question(
            22,
            "Which country has the most natural lakes?",
            listOf("United States", "Canada", "Russia", "Finland"),
            1,
            "It's known for its maple syrup"
        ),
        Question(
            23,
            "What is the largest bird in the world?",
            listOf("Emu", "Ostrich", "Albatross", "Eagle"),
            1,
            "It can't fly but can run very fast"
        ),
        Question(
            24,
            "Who painted 'The Starry Night'?",
            listOf("Pablo Picasso", "Vincent van Gogh", "Claude Monet", "Salvador Dali"),
            1,
            "He cut off his own ear"
        ),
        Question(
            25,
            "What is the fastest land animal?",
            listOf("Lion", "Cheetah", "Gazelle", "Antelope"),
            1,
            "It can reach speeds up to 70 mph"
        )
    )

    private var currentQuestionIndex = 0

    init {
        _score.value = 0
        _currentLevel.value = 1
        loadQuestion(currentQuestionIndex)
    }

    private fun loadQuestion(index: Int) {
        if (index < questions.size) {
            _currentQuestion.value = questions[index]
        }
    }

    fun checkAnswer(selectedIndex: Int) {
        val question = _currentQuestion.value ?: return
        if (selectedIndex == question.correctAnswerIndex) {
            _score.value = (_score.value ?: 0) + 1
        }
    }

    fun moveToNextQuestion() {
        viewModelScope.launch {
            _isTransitioning.value = true
            delay(300) // Match animation duration
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                loadQuestion(currentQuestionIndex)
            }
            _isTransitioning.value = false
        }
    }

    fun isLastQuestion(): Boolean {
        return currentQuestionIndex >= questions.size - 1
    }

    fun getCurrentQuestionNumber(): Int {
        return currentQuestionIndex + 1
    }

    fun getTotalQuestions(): Int {
        return questions.size
    }
} 