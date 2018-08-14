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
            new Fabric("Cait", "knit", "DBP", R.drawable.cait, "Brushed Polyester/Spandex\n" +
                    "\n" +
                    "\"Double\" - means the fabric is brushed on both sides\n" +
                    "\"Single\" - means fabric is brushed on one side, smooth on the other. \n" +
                    "96% POLYESTER / 4% SPANDEX\n" +
                    "58\"/60\"\" wide \n" +
                    "Medium weight\n" +
                    "4 - WAY stretch\n" +
                    "Works very well for dresses, leggings, tops, etc.\n" +
                    "CARE: Wash on cold, tumble dry"),
            new Fabric("Devon", "knit", "hacci sweater", R.drawable.devon, "HACCI SWEATER KNIT\n" +
                    "POLY/SPANDEX\n" +
                    "If listing says “Brushed” means is has a brushed “fuzzy” texture to it\n" +
                    "4-way stretch\n" +
                    "Medium weight\n" +
                    "58\" Wide\n" +
                    "This fabric is very soft and cozy. Perfect for sweaters, tops and dresses. \n" +
                    "CARE: wash cold, tumble dry or lay flat to dry"),
            new Fabric("Jamie", "knit", "DBP", R.drawable.jamie, "Brushed Polyester/Spandex\n" +
                    "\n" +
                    "\"Double\" - means the fabric is brushed on both sides\n" +
                    "\"Single\" - means fabric is brushed on one side, smooth on the other. \n" +
                    "96% POLYESTER / 4% SPANDEX\n" +
                    "58\"/60\"\" wide \n" +
                    "Medium weight\n" +
                    "4 - WAY stretch\n" +
                    "Works very well for dresses, leggings, tops, etc.\n" +
                    "CARE: Wash on cold, tumble dry"),
            new Fabric("Maize", "knit", "DBP", R.drawable.maize, "Brushed Polyester/Spandex\n" +
                    "\n" +
                    "\"Double\" - means the fabric is brushed on both sides\n" +
                    "\"Single\" - means fabric is brushed on one side, smooth on the other. \n" +
                    "96% POLYESTER / 4% SPANDEX\n" +
                    "58\"/60\"\" wide \n" +
                    "Medium weight\n" +
                    "4 - WAY stretch\n" +
                    "Works very well for dresses, leggings, tops, etc.\n" +
                    "CARE: Wash on cold, tumble dry"),
            new Fabric("Serenity", "knit", "Viscose, Bamboo & Spandex", R.drawable.serenity, "4-way stretch\n" +
                    "96% Viscose from Bamboo/4% spandex\n" +
                    "58\"-60\" WIDE Very soft with a nice drape. This fabric works really well for tops, dresses, skirts, etc.\n" +
                    "CARE: wash cold, tumble dry")
    };

    private ImageView picture;
    private TextView name;
    private TextView category;
    private TextView type;
    private TextView description;
    private TextView imageCount;

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
        description = findViewById(R.id.fabricDescription);
        imageCount = findViewById(R.id.imageCountTracker);


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

        imageCount.setText((currentIndex+1) + "/" + fabric.length);

        Fabric fabrics = fabric[currentIndex];
        name.setText(fabrics.name);
        category.setText(fabrics.catagory);
        type.setText(fabrics.type);
        description.setText(fabrics.description);

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