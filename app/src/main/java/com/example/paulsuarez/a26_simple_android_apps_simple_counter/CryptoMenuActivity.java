package com.example.paulsuarez.a26_simple_android_apps_simple_counter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.paulsuarez.a26_simple_android_apps_simple_counter.models.CryptoMenu;

public class CryptoMenuActivity  extends AppCompatActivity {
    private int currentIndex;

    CryptoMenu[] coins = {
            new CryptoMenu("Bitcoin", R.drawable.bitcoin, "Bitcoin uses peer-to-peer technology to operate with no central authority or banks; managing transactions and the issuing of bitcoins is carried out collectively by the network.                                                                                                                                                "),
            new CryptoMenu("Litecoin", R.drawable.litecoin, "Litecoin is a peer-to-peer Internet currency that enables instant, near-zero cost payments to anyone in the world.                                                                                                                                                                                                             "),
            new CryptoMenu("EncryptNode", R.drawable.encrytnode, "EncryptNode aims to simplify blockchain technology and make it accessible to everyone. Hashed using a SHA256 encryption algorithm; EncryptNode is both efficient and secure!                                                                                                                                              ")
    };

    private ImageView picture;
    private TextView name;
    private TextView desc;

    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }


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



}
