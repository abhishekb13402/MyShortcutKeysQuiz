package com.example.myshortcutkeysquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizmicrosoft extends AppCompatActivity {
    private int currentQuestion = 0;
    private int score = 0;

    private String[] questions = {
            "1) Switch between open applications",
            "2) Switch backwards between open applications",
            "3) Screen Create screen shot for current program",
            "4) Reboot/Windows® task manager",
            "5) Bring up start menu",
            "6) Switch between applications on taskbar",
            "7) Rename selected icon",
            "8) Start find from desktop",
            "9) Open the drive selection when browsing",
            "10) Refresh contents",
            "11) Close current open program",
            "12) Close window in program",
            "13) Automatically adjust widths of all columns in Windows Explorer",
            "14) Open properties window of selected icon or program",
            "15) Simulate right-click on selected item",
            "16) Delete programs/files permanently"
    };

    private String[][] answerChoices  = {
            {"Alt + Tab","Tab"},
            {"back","Alt + Shift + Tab"},
            {"Alt + Print","print"},
            {"reboot","Ctrl + Alt + Del"},
            {"Ctrl + Esc","start btn"},
            {"taskbar icon","Alt + Esc"},
            {"F2","F3"},
            {"F2","F3"},
            {"F4","F3"},
            {"F4","F5"},
            {"Alt + F4","F5"},
            {"F4","Ctrl + F4"},
            {"Ctrl + Plus Key","plus"},
            {"enter","Alt + Enter"},
            {"Shift + F10","F10"},
            {"del","Shift + Del"}
    };

    private int[] correctAnswers = {0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1};

    private Button[] answerButtons;
    private TextView questionTextView;
    private TextView feedbackTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizmicrosoft);
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