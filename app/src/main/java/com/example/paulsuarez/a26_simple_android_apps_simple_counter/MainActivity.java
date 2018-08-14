package com.example.paulsuarez.a26_simple_android_apps_simple_counter;


import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulsuarez.a26_simple_android_apps_simple_counter.models.CryptoMenu;

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




        // testing
        currentIndex = 0;

        picture = findViewById(R.id.picture);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        showCoin();

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrement();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increment();
            }
        });
        //



    }




    // trying to make a single scrollable app:

    private int currentIndex;

    CryptoMenu[] coins = {
            new CryptoMenu("Bitcoin", R.drawable.bitcoin, "Bitcoin uses peer-to-peer technology to operate with no central authority or banks; managing transactions and the issuing of bitcoins is carried out collectively by the network."),
            new CryptoMenu("Litecoin", R.drawable.litecoin, "Litecoin is a peer-to-peer Internet currency that enables instant, near-zero cost payments to anyone in the world."),
            new CryptoMenu("EncryptNode", R.drawable.encrytnode, "EncryptNode aims to simplify blockchain technology and make it accessible to everyone. Hashed using a SHA256 encryption algorithm; EncryptNode is both efficient and secure!")
    };

    private ImageView picture;
    private TextView name;
    private TextView desc;

    private Button prev;
    private Button next;




    public void increment() {
        currentIndex++;
        showCoin();
    }

    public void decrement() {
        currentIndex--;
        showCoin();
    }

    public void showCoin() {
        cycleBounds();

        CryptoMenu coin = coins[currentIndex];
        name.setText(coin.name);
        desc.setText(coin.description);

        Drawable pic = getResources().getDrawable(coin.drawableId);
        picture.setImageDrawable(pic);
    }

    // puts the menu on an infinite loop.
    public void cycleBounds() {
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = coins.length - 1;
        } else {
            currentIndex = currentIndex % coins.length;
        }
    }



    //


}


