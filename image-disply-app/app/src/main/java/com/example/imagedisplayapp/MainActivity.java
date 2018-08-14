package com.example.imagedisplayapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagedisplayapp.models.Fabric;

public class MainActivity extends AppCompatActivity {

    private int currentIndex;

    Fabric[] fabric = {
            new Fabric("Cait", "knit", "DBP", R.drawable.cait),
            new Fabric("Devon", "knit", "hacci sweater", R.drawable.devon),
            new Fabric("Jamie", "knit", "DBP", R.drawable.jamie),
            new Fabric("Maize", "knit", "DBP", R.drawable.maize),
            new Fabric("Serenity", "knit", "DBP", R.drawable.serenity)
    };

    private ImageView picture;
    private TextView name;
    private TextView category;
    private TextView type;

    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentIndex = 0;

        picture = findViewById(R.id.picture);
        name = findViewById(R.id.name);
        category = findViewById(R.id.category);
        type = findViewById(R.id.type);


        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        showFabric();

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
        showFabric();
    }

    public void decrement() {
        currentIndex--;
        showFabric();
    }

    public void showFabric() {
        cycleBounds();

        Fabric fabrics = fabric[currentIndex];
        name.setText(fabrics.name);
        category.setText(fabrics.catagory);
        type.setText(fabrics.type);

        Drawable pic = getResources().getDrawable(fabrics.drawableId);
        picture.setImageDrawable(pic);
    }

    public void cycleBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = fabric.length - 1;
        } else {
            currentIndex = currentIndex % fabric.length;
        }
    }

    public void preventBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        // guarantee the current index is between zero and the length of the array
        currentIndex = Math.max(currentIndex, 0);
        currentIndex = Math.min(currentIndex, fabric.length - 1);

        // deal with the worst
        if (currentIndex == fabric.length - 1) {
            next.setEnabled(false);
        }

        if (currentIndex == 0) {
            prev.setEnabled(false);
        }

    }
}