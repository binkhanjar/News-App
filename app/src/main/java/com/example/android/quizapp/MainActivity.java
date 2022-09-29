package com.example.android.quizapp;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    // subScores
    private int scoreQuestion1;
    private int scoreQuestion2;
    private int scoreQuestion3;
    private int scoreQuestion4;
    private int scoreQuestion5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Answer Button
    public void AnswerButton(View view) {
        checkboxQ2();
        editTextQ3();

        // total score
        int scoreTotal = scoreQuestion1 + scoreQuestion2 + scoreQuestion3 + scoreQuestion4 + scoreQuestion5;

        if (scoreTotal >= 3) {
            Toast.makeText(this, getString(R.string.successful) + "\nCorrect Answers: " + scoreTotal, Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, getString(R.string.Try_again) + "\nCorrect Answers: " + scoreTotal, Toast.LENGTH_SHORT).show();
        }

        clearQuiz();
    }

    // To make the answer field blank after sending the answer
    private void clearQuiz() {
        scoreQuestion1 = 0;
        scoreQuestion2 = 0;
        scoreQuestion3 = 0;
        scoreQuestion4 = 0;
        scoreQuestion5 = 0;

        RadioGroup radioGQ1 = findViewById(R.id.rg_q1);
        radioGQ1.clearCheck();

        CheckBox checkboxCb1 = findViewById(R.id.cb1_messi);
        checkboxCb1.setChecked(false);
        CheckBox checkboxCb2 = findViewById(R.id.cb2_ronaldo);
        checkboxCb2.setChecked(false);
        CheckBox checkboxCb3 = findViewById(R.id.cb3_ibrahimovic);
        checkboxCb3.setChecked(false);
        CheckBox checkboxCb4 = findViewById(R.id.cb4_iniesta);
        checkboxCb4.setChecked(false);

        EditText editTextQ3 = findViewById(R.id.et_answer3);
        editTextQ3.setText("");

        RadioGroup radioQ4 = findViewById(R.id.rg_q4);
        radioQ4.clearCheck();

        RadioGroup radioQ5 = findViewById(R.id.rg_q5);
        radioQ5.clearCheck();
    }

    // Question one
    public void radioButtonQ1(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.rb_q1_answer3) {
            if (checked)
                scoreQuestion1 = 1;
        } else {
            scoreQuestion1 = 0;
        }
    }

    // Question two
    private void checkboxQ2() {
        CheckBox checkbox1 = findViewById(R.id.cb1_messi);
        boolean messi = checkbox1.isChecked();
        CheckBox checkbox2 = findViewById(R.id.cb2_ronaldo);
        boolean ronaldo = checkbox2.isChecked();
        CheckBox checkbox3 = findViewById(R.id.cb3_ibrahimovic);
        boolean ibrahimovic = checkbox3.isChecked();
        CheckBox checkbox4 = findViewById(R.id.cb4_iniesta);
        boolean iniesta = checkbox4.isChecked();

        if (messi && ronaldo && !ibrahimovic && !iniesta) {
            scoreQuestion2 = 1;
        } else {
            scoreQuestion2 = 0;
        }
    }

    // Question three
    public void editTextQ3() {
        EditText editTQ3 = findViewById(R.id.et_answer3);
        String Q3Answer = editTQ3.getText().toString();
        if (Q3Answer.equalsIgnoreCase("BRAZIL")) {
            scoreQuestion3 = 1;
        } else {
            scoreQuestion3 = 0;
        }
    }

    // Question four
    public void trueOrFalse(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.rb_q4_answer_false) {
            if (checked) {
                scoreQuestion4 = 1;
            } else {
                scoreQuestion4 = 0;
            }
        }
    }

    // Question five
    public void radioButtonQ5(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        if (view.getId() == R.id.rb_q5_answer1) {
            if (checked) {
                scoreQuestion5 = 1;
            } else {
                scoreQuestion5 = 0;
            }
        }
    }
}