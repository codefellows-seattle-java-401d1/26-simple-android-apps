package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int clicks1 = 0;
    private int clicks2 = 0;

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    private TextView mText1;
    private TextView mText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mText1 = findViewById(R.id.clicks1);
        mText2 = findViewById(R.id.clicks2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);

        mButton1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicks1++;
                mText1.setText("Clicks:" + clicks1);
            }
        });

        mButton2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicks2++;
                mText2.setText("Clicks:" + clicks2);
            }
        });
        mButton3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicks1--;
                mText1.setText("Clicks:" + clicks1);
            }
        });

        mButton4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                clicks2--;
                mText2.setText("Clicks:" + clicks2);
            }
        });
    }
}
