package com.example.paulsuarez.a26_simple_android_apps_simple_counter;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int totalClicks;

    private int aClicks;
    private int bClicks;
    private int cClicks;

    private Button mClickMe;
    private TextView mClicks;


    private Button mAButton;
    private TextView mAText;

    private Button mBButton;
    private TextView mBText;

    private Button mCButton;
    private TextView mCText;

    private EditText mEditText;
    private Button mManualUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.manualEntry);
        mManualUpdate = findViewById(R.id.manualUpdate);

        Log.d("clickApp", "it's running!");

        mClickMe = findViewById(R.id.clickMe);

        mAButton = findViewById(R.id.aClickMe);
        mBButton = findViewById(R.id.bClickMe);
        mCButton = findViewById(R.id.cClickMe);


        mClicks = findViewById(R.id.clicks);

        mAText = findViewById(R.id.aClicks);
        mBText = findViewById(R.id.bClicks);
        mCText = findViewById(R.id.cClicks);

        mManualUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = mEditText.toString();
                String text2 = mEditText.getText().toString();

                totalClicks = Integer.parseInt(text2);
                mClicks.setText("clicks: " + totalClicks);
            }
        });

        mClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalClicks++;
                mClicks.setText("clicks: " + totalClicks);

            }
        });

        mAButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aClicks++;
                mAText.setText("Bitcoins Ordered: " + aClicks);

            }
        });


        mBButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bClicks++;
                mBText.setText("Litecoins Ordered: " + bClicks);

            }
        });


        mCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cClicks++;
                mCText.setText("EncryptNodes Ordered: " + cClicks);

            }
        });








    }


}
