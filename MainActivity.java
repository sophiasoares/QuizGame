package de.thu.quizgame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    QuestionRepository questionRepository =  new QuestionRepository();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionRepository.createRepository();

        showQuestion();
    }

    void showQuestion() {

        // Pick a random question
        Question chosenQuestion = questionRepository.randomQuestion();

        // Show the random question
        TextView textView = (TextView) findViewById(R.id.questionText);
        textView.setText(chosenQuestion.getQuestion());

        // Set the buttons' texts and enables them
        Button button = (Button) findViewById(R.id.answer1);
        button.setText(chosenQuestion.getAnswers()[0]);
        button.setEnabled(true);

        button = (Button) findViewById(R.id.answer2);
        button.setText(chosenQuestion.getAnswers()[1]);
        button.setEnabled(true);

        button = (Button) findViewById(R.id.answer3);
        button.setText(chosenQuestion.getAnswers()[2]);
        button.setEnabled(true);

        button = (Button) findViewById(R.id.answer4);
        button.setText(chosenQuestion.getAnswers()[3]);
        button.setEnabled(true);

    }

    public void myButtonClicked (View view) {
        Log.i("Quiz Game", "Button was clicked!");

        Button clickedButton = (Button) view;
        if(clickedButton.getText() == questionRepository.myQuestion.getAnswers()[questionRepository.myQuestion.getCorrectAnswer()]) {
            showQuestion();
        } else {
            clickedButton.setEnabled(false);
        }
    }
}