package com.example.helloworld;

public class Quiz {
    private String questions [] = {
            "What are the symptoms of COVID-19 infection?",
            "How can I avoid getting infected?",
            "How can I avoid infecting others?",
            "Are face masks effective in protecting against COVID-19?",
            "Are dogs and cats spreading the virus?",
            "Where was the first COVID-19 case?"
    };

    private String answers [][] = {
            {"Lying", "Buying toilet paper", "High temperature"},
            {"By staying at home", "By shopping", "By touching everything"},
            {"Make a distance", "Use public transport", "Don't wash hands"},
            {"No", "Yes", "Only in China"},
            {"No", "Yes", "It depends"},
            {"Warsaw", "Sosnowiec", "Wuhan"}
    };

    private String correctAnswers[] = {"High temperature", "By staying at home", "Make a distance", "Yes", "No", "Wuhan"};

    public String getQuestion(int index) {
        String question = questions[index];
        return question;
    }

    public String getChoice1(int index) {
        return answers[index][0];
    }

    public String getChoice2(int index) {
        return answers[index][1];
    }

    public String getChoice3(int index) {
        return answers[index][2];
    }

    public String getCorrectAnswer(int index) {
        return correctAnswers[index];
    }
}
