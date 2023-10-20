package com.example.myshortcutkeysquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizbasic extends AppCompatActivity {
    private int currentQuestion = 0;
    private int score = 0;

    private String[] questions = {
            "1) File menu options in current program",
            "2) Edit options in current program",
            "3) Universal help (for all programs)",
            "4) Select all text",
            "5) Cut selected item",
            "6) Cut selected item",
            "7) Copy selected item",
            "8) Copy selected item",
            "9) Paste",
            "10) Paste",
            "11) Go to beginning of current line",
            "12) Go to beginning of document",
            "13) Go to end of current line",
            "14) Go to end of document",
            "15) Highlight from current position to beginning of line",
            "16) Highlight from current position to end of line",
            "17) Move one word to the left at a time",
            "18) Move one word to the right at a time"
    };

    private String[][] answerChoices  = {
            {"Alt + F","Alt + E"},
            {"F1","Alt + E"},
            {"F1","F2"},
            {"AA","Ctrl + A"},
            {"Ctrl + X","Del"},
            {"X","Shift + Del"},
            {"Ctrl + C","Copy"},
            {"Ctrl + Ins","copy"},
            {"paste","Ctrl + V"},
            {"Shift + Ins","v"},
            {"Home","h"},
            {"h","Ctrl + Home"},
            {"End","last"},
            {"last","Ctrl + End"},
            {"Shift + Home","homeplace"},
            {"Shift + End","endplace"},
            {"Ctrl + <-","left"},
            {"right","Ctrl + ->"}
    };

    private int[] correctAnswers = {0,1,0,1,0,1,0,0,1,1,0,1,0,1,0,0,0,1};

    private Button[] answerButtons;
    private TextView questionTextView;
    private TextView feedbackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizbasic);
        questionTextView = findViewById(R.id.questionTextView);
        feedbackTextView = findViewById(R.id.feedbackTextView);

        answerButtons = new Button[2]; // Assuming we have 2 answer choices
        answerButtons[0] = findViewById(R.id.choice1Button);
        answerButtons[1] = findViewById(R.id.choice2Button);

        // Set click listeners for answer buttons
        for (int i = 0; i < answerButtons.length; i++) {
            final int buttonIndex = i;
            answerButtons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onAnswerSelected(answerButtons[buttonIndex]);
                }
            });
        }

        displayQuestion(currentQuestion);
    }

    public void onAnswerSelected(View view) {
        Button selectedButton = (Button) view;
        String selectedAnswer = selectedButton.getText().toString();
        String correctAnswer = String.valueOf(correctAnswers[currentQuestion]);

        if (selectedAnswer.equals(answerChoices[currentQuestion][Integer.parseInt(correctAnswer)])) {
            score++;
            feedbackTextView.setText("Correct!");
        } else {
            feedbackTextView.setText("Incorrect. The correct answer is: " + correctAnswer);
        }

        // Move to the next question
        currentQuestion++;
        if (currentQuestion < questions.length) {
            displayQuestion(currentQuestion);
        } else {
            // End of quiz, show the result
            showResult();
        }
    }

    private void displayQuestion(int questionIndex) {
        questionTextView.setText(questions[questionIndex]);
        List<String> choices = new ArrayList<>();
        Collections.addAll(choices, answerChoices[questionIndex]);
        Collections.shuffle(choices);

        for (int i = 0; i < answerButtons.length; i++) {
            answerButtons[i].setText(choices.get(i));
        }
        feedbackTextView.setText("");
    }

    private void showResult() {
        questionTextView.setText("Quiz Completed");
        for (Button button : answerButtons) {
            button.setVisibility(View.GONE);
        }
        feedbackTextView.setText("Your score: " + score + " out of " + questions.length);
    }
}