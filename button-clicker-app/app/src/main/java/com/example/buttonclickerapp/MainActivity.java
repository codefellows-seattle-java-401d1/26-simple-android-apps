package com.example.buttonclickerapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView showValueTeamA;
    TextView showValueTeamB;
    int counterTeamA = 0;
    int counterTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showValueTeamA = (TextView) findViewById(R.id.counterValueTeamA);
        showValueTeamB = (TextView) findViewById(R.id.counterValueTeamB);
    }

    public void countINCREASETeamA(View view) {
        counterTeamA++;
        showValueTeamA.setText(Integer.toString(counterTeamA));
    }

    public void countDECREASETeamA(View view) {
        counterTeamA--;
        showValueTeamA.setText(Integer.toString(counterTeamA));
    }

    public void countINCREASETeamB(View view) {
        counterTeamB++;
        showValueTeamB.setText(Integer.toString(counterTeamB));
    }

    public void countDECREASETeamB(View view) {
        counterTeamB--;
        showValueTeamB.setText(Integer.toString(counterTeamB));
    }
}
