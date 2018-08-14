package com.yutani.codefellows.a26_simple_android_apps.imginfo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yutani.codefellows.a26_simple_android_apps.R;
import com.yutani.codefellows.a26_simple_android_apps.imginfo.models.Mountain;

public class ImgActivity extends AppCompatActivity {
    Mountain[] mountains = {
            new Mountain(R.drawable.shuksan,"Mt. Shuksan", "9,131 ft.", "\"Mt. Shuksan epitomizes the jagged alpine peak like no other massif in the North Cascades... it has no equal in the range when one considers the structural beauty of its four major faces and five ridges...There is no other sample in the American West of a peak with great icefall glaciers derived from a high plateau, and in the Pacific Northwest it is the only non-volcanic peak whose summit exceeds timberline by more than 3000 feet... Shuksan is one of the finest mountaineering objectives in the North Cascades and its reputation is certainly deserved; a wide variety of challenges can be encountered on this quite complex mountain. The climber has a choice of rock walls, moderate firnfields, steep ice, and easy scrambling. Despite a sometimes-forbidding appearance, Shuksan has yielded 14 routes, numerous variations, and impressive subsidiary climbs, including some directly up dangerous ice cliffs.\" - Fred Becky "),
            new Mountain(R.drawable.forbiddenpeak,"Forbidden Peak", "8,816 ft.", "Forbidden Peak is a beautiful sight to climbers, with 3 perfect ridges converging towards a pointed summit. This is one of the most popular mountains in the entire Cascades, for good reason. The routes are clean, classic, and the rock quality is good by alpine standards. The surrounding area is splendid and the views from the summit are hard to beat. The Nelson guide states that \"there is no easy way off Forbidden Peak; it is one of the most difficult descents in the range.\" Come prepared, but don't let this deter you. It's not as bad as it sounds, and it's absolutely worth it."),
            new Mountain(R.drawable.stuart,"Mt. Stuart", "9,416 ft.", "\"Without a rival as the crown peak in the central Cascades of Washington, Mount Stuart has been pronounced the single greatest mass of exposed granite in the United States...its northern and eastern faces are the alpine climax of the Wenatchee Mountains. They make a powerful impact on first sight...The mountaineering problems are magnified by the mountain's massive dimensions and its complexity.\" - Fred Beckey"),
            new Mountain(R.drawable.slesse,"Slesse Mountain", "8,002 ft.", "Slesse Mountain is a prominent peak in the Pacific Northwest's North Cascades, two miles north of the British Columbia-U.S. border, close to the same longitude as Mt. Shuksan. Slesse means \"fang\" in the native Salish tongue, which aptly describes it's spire profile from many directions. The B.C. town of Chilliwack to the NW is the nearest large community.")
    };

    private ImageView img;
    private TextView name;
    private TextView elevation;
    private TextView description;

    private Button prev;
    private Button next;

    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        currentIndex = 0;

        img = findViewById(R.id.img);
        name = findViewById(R.id.name);
        elevation = findViewById(R.id.elevation);
        description = findViewById(R.id.description);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        showMtn();

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });
    }

    public void increment () {
        currentIndex++;
        showMtn();
    }

    public void decrement () {
        currentIndex--;
        showMtn();
    }

    public void showMtn () {
        cycleImgs();

        Mountain mtn = mountains[currentIndex];

        Drawable pic = getResources().getDrawable(mtn.imgId);
        img.setImageDrawable(pic);

        name.setText(mtn.name);
        elevation.setText(mtn.elevation);
        description.setText(mtn.description);
    }

    public void cycleImgs () {
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = mountains.length -1;
        } else {
            currentIndex = currentIndex % mountains.length;
        }
    }
}
