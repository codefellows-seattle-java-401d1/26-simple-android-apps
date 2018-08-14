package com.gbbeard.countingbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int totalClicks;
    private int firstClicks;
    private int secondButtonClicks;
    private int thirdButtonClicks;

    private Button mClickMe;
    private Button mFirstButton;
    private Button mSecondButton;
    private Button mThirdButton;

    private TextView mClicks;
    private TextView mFirstTextView;
    private TextView mSecondTextView;
    private TextView mThirdTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickMe = findViewById(R.id.clickMe);
        mFirstButton = findViewById(R.id.firstButton);
        mSecondButton = findViewById(R.id.secondButton);
        mThirdButton = findViewById(R.id.thirdButton);

        mClicks = findViewById(R.id.clicks);
        mFirstTextView = findViewById(R.id.firstText);
        mSecondTextView = findViewById(R.id.secondText);
        mThirdTextView = findViewById(R.id.thirdText);

        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalClicks++;
                mClicks.setText("Games Total: " + totalClicks);
            }
        });

        mFirstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstClicks++;
                mFirstTextView.setText("Wins: " + firstClicks);
            }
        });

        mSecondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secondButtonClicks++;
                mSecondTextView.setText("Losses: " + secondButtonClicks);
            }
        });

        mThirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                thirdButtonClicks++;
                mThirdTextView.setText("Ties: " + thirdButtonClicks);
            }
        });
    }
}