package com.example.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class QuizActivity : AppCompatActivity() {
    private val quiz = Quiz()
    private var scoreView: TextView? = null
    private var questionView: TextView? = null
    private var firstButton: Button? = null
    private var secondButton: Button? = null
    private var thirdButton: Button? = null
    private var answer: String? = null
    private var score = 0
    private var questionNumber = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiz)

        scoreView = findViewById(R.id.score) as TextView
        questionView = findViewById(R.id.question) as TextView
        firstButton = findViewById(R.id.choice1) as Button
        secondButton = findViewById(R.id.choice2) as Button
        thirdButton = findViewById(R.id.choice3) as Button

        updateQuestion()

        this.setupOnClickListener(firstButton!!)
        this.setupOnClickListener(secondButton!!)
        this.setupOnClickListener(thirdButton!!)
    }

    private fun setupOnClickListener(button: Button) {
        button.setOnClickListener {
            if (button.text === answer) {
                score = score + 1
                updateScore(score)
                updateQuestion()
                Toast.makeText(this@QuizActivity, "correct", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@QuizActivity, "wrong", Toast.LENGTH_SHORT).show()
                updateQuestion()
            }
        }
    }

    private fun updateQuestion() {
        questionView!!.text = quiz.getQuestion(questionNumber)
        firstButton!!.text = quiz.getChoice1(questionNumber)
        secondButton!!.text = quiz.getChoice2(questionNumber)
        thirdButton!!.text = quiz.getChoice3(questionNumber)

        answer = quiz.getCorrectAnswer(questionNumber)
        questionNumber++
    }

    private fun updateScore(point: Int) {
        scoreView!!.text = "" + score
    }
}
