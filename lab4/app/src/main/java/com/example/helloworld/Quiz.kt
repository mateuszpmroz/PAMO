package com.example.helloworld

class Quiz {
    private val questions = arrayOf("What are the symptoms of COVID-19 infection?", "How can I avoid getting infected?", "How can I avoid infecting others?", "Are face masks effective in protecting against COVID-19?", "Are dogs and cats spreading the virus?", "Where was the first COVID-19 case?")

    private val answers = arrayOf(arrayOf("Lying", "Buying toilet paper", "High temperature"), arrayOf("By staying at home", "By shopping", "By touching everything"), arrayOf("Make a distance", "Use public transport", "Don't wash hands"), arrayOf("No", "Yes", "Only in China"), arrayOf("No", "Yes", "It depends"), arrayOf("Warsaw", "Sosnowiec", "Wuhan"))

    private val correctAnswers = arrayOf("High temperature", "By staying at home", "Make a distance", "Yes", "No", "Wuhan")

    fun getQuestion(index: Int): String {
        return questions[index]
    }

    fun getChoice1(index: Int): String {
        return answers[index][0]
    }

    fun getChoice2(index: Int): String {
        return answers[index][1]
    }

    fun getChoice3(index: Int): String {
        return answers[index][2]
    }

    fun getCorrectAnswer(index: Int): String {
        return correctAnswers[index]
    }
}
