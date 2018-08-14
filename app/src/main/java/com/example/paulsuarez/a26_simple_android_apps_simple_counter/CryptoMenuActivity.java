package com.example.paulsuarez.a26_simple_android_apps_simple_counter;

import android.support.v7.app.AppCompatActivity;

import com.example.paulsuarez.a26_simple_android_apps_simple_counter.models.CryptoMenu;

public class CryptoMenuActivity  extends AppCompatActivity {
    private int currentIndex;

    CryptoMenu[] coins = {

            new CryptoMenu("Bitcoin", R.drawable.bitcoin, "Bitcoin uses peer-to-peer technology to operate with no central authority or banks; managing transactions and the issuing of bitcoins is carried out collectively by the network.")
    };


}
