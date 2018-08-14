package com.example.simplecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int totalClicks;

    private Button mClickMe;
    private TextView mClicks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mClickMe = findViewById(R.id.clickMe);
        mClicks = findViewById(R.id.clicks);
    }
}
