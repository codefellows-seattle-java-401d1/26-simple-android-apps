package com.yutani.codefellows.a26_simple_android_apps.counter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yutani.codefellows.a26_simple_android_apps.R;

public class CounterActivity extends AppCompatActivity {
    private int homeClicks = 0;
    private int awayClicks = 0;

    private Button mHomeButton;
    private Button mAwayButton;

    private TextView mHomeScore;
    private TextView mAwayScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        mHomeButton = findViewById(R.id.homeButton);
        mAwayButton = findViewById(R.id.awayButton);

        mHomeScore = findViewById(R.id.homeScore);
        mAwayScore = findViewById(R.id.awayScore);

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                homeClicks++;
                mHomeScore.setText("" + homeClicks);
            }
        });

        mAwayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                awayClicks++;
                mAwayScore.setText("" + awayClicks);
            }
        });
    }
}
