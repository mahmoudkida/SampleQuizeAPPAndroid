package com.wshwsh.sample_quize_app_android;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class Videogame_Quiz extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videogame__quiz);
    }

    private int totalMark = 0;
    private int numberOfQuestions = 4;
    String Anwser1 = "Sony";
    String Anwser2 = "Zelda";
    String Anwser3A = "Pikatchu";
    String Anwser3B = "Pulbasur";
    String Anwser3C = "Charmender";
    String Anwser4 = "Blue";

    public void viewAnswers(View view) {
        totalMark = 0;
        if (checkForAnwser("radiobutton", Anwser1, new String[]{Anwser1})) {
            totalMark++;
        }
        if (checkForAnwser("textbox", "question2anwser", new String[]{Anwser2})) {
            totalMark++;
        }
        if (checkForAnwser("checbox", Anwser4, new String[]{Anwser3A, Anwser3B, Anwser3C})) {
            totalMark++;
        }
        if (checkForAnwser("radiobutton", Anwser4, new String[]{Anwser4})) {
            totalMark++;
        }
        Context context = getApplicationContext();
        CharSequence text = "Your test score is " + totalMark + " of " + numberOfQuestions;
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private boolean checkForAnwser(String anwserType, String inputName, String[] anwser) {
        if (anwserType.equals("textbox")) {
            EditText anwserInput = (EditText) findViewById(getResources().getIdentifier(inputName, "id", getPackageName()));
            if (anwser[0].equalsIgnoreCase(anwserInput.getText().toString())) {
                return true;
            }
        } else if (anwserType.equals("radiobutton")) {
            RadioButton anwserInput = (RadioButton) findViewById(getResources().getIdentifier(inputName, "id", getPackageName()));
            if (anwserInput.isChecked()) {
                return true;
            }
        } else if (anwserType.equals("checbox")) {
            int anwserLength = anwser.length;
            int correctAnwsers = 0;
            for (int anwserIndex = 0; anwserIndex < anwserLength; anwserIndex++) {
                CheckBox anwserInput = (CheckBox) findViewById(getResources().getIdentifier(anwser[anwserIndex], "id", getPackageName()));
                if (anwserInput.isChecked()) {
                    correctAnwsers++;
                }
            }
            if (correctAnwsers == anwserLength) {
                return true;
            }
        }
        return false;
    }
}
