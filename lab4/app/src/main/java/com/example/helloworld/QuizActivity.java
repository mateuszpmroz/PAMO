//package com.example.helloworld;
//import android.os.Bundle;
//import androidx.appcompat.app.AppCompatActivity;
//import android.view.View;
//import android.widget.Button;
//import android.widget.TextView;
//import android.widget.Toast;
//
//public class QuizActivity extends AppCompatActivity {
//    private Quiz quiz = new Quiz();
//    private TextView scoreView;
//    private TextView questionView;
//    private Button firstButton;
//    private Button secondButton;
//    private Button thirdButton;
//    private String answer;
//    private int score = 0;
//    private int questionNumber = 0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.quiz);
//
//        scoreView = (TextView) findViewById(R.id.score);
//        questionView = (TextView) findViewById(R.id.question);
//        firstButton = (Button) findViewById(R.id.choice1);
//        secondButton = (Button) findViewById(R.id.choice2);
//        thirdButton = (Button) findViewById(R.id.choice3);
//
//        updateQuestion();
//
//        this.setupOnClickListener(firstButton);
//        this.setupOnClickListener(secondButton);
//        this.setupOnClickListener(thirdButton);
//    }
//
//    private void setupOnClickListener(final Button button) {
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (button.getText() == answer) {
//                    score = score + 1;
//                    updateScore(score);
//                    updateQuestion();
//                    Toast.makeText(QuizActivity.this, "correct", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(QuizActivity.this, "wrong", Toast.LENGTH_SHORT).show();
//                    updateQuestion();
//                }
//            }
//        });
//    }
//
//    private void updateQuestion() {
//        questionView.setText(quiz.getQuestion(questionNumber));
//        firstButton.setText(quiz.getChoice1(questionNumber));
//        secondButton.setText(quiz.getChoice2(questionNumber));
//        thirdButton.setText(quiz.getChoice3(questionNumber));
//
//        answer = quiz.getCorrectAnswer(questionNumber);
//        questionNumber++;
//    }
//
//    private void updateScore(int point) {
//        scoreView.setText("" + score);
//    }
//}
