package com.example.imagedisplay;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imagedisplay.models.Gallery;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView description;
    Button previous;
    Button next;
    ImageView image;

    TextView title;
    TextView workDescription;
    Button prevWork;
    Button nextWork;
    ImageView work;

    int currentIndex;
    int currentWorkIndex;

    Gallery[]galleries = {
            new Gallery("Seattle Art Museum",R.drawable.gallery1,"Our very own homegrown art exhibition."),
            new Gallery("Louvre",R.drawable.gallery2,"The most famous art gallery in the world."),
            new Gallery("New York Metropolitan Museum of Art", R.drawable.gallery3,"North America's most famous art museum.")
};
    Gallery[]louvre = {
            new Gallery("Mona Lisa", R.drawable.monalisa,"The most famous painting of all time."),
            new Gallery("David", R.drawable.david, "A marble revival of Greek ideas. By Michealangelo."),
            new Gallery("Code of Hammurabi", R.drawable.code, "A copy of the oldest set of laws known to man. 1754 BC")
                };
    Gallery[]met = {
            new Gallery("The Scream", R.drawable.munch,"A classic of expressionism. By Edward Munch."),
            new Gallery("Jeanne Hebuterne", R.drawable.modigliani, "Portraiture in a modern style. By Amadeo Modigliani."),
            new Gallery("Self Portrait", R.drawable.vangogh, "One of the best known work of one of the worlds classic tragic artists. Van Gogh.")
    };
    Gallery[]sam = {
            new Gallery("Buddhist Statues", R.drawable.buddhist,"A sculpture of the buddha."),
            new Gallery("A Country Home", R.drawable.countryhome, "A breathtaking landscape in the Hudson River style by Frederich Church."),
            new Gallery("Deer Scroll", R.drawable.deer, "30 feet from one of the largest contigious art pieces of all time. Created by Sotatsu and Koetsu in the 1610's")
    };
    Gallery[][]Collections = {
            sam,
            louvre,
            met
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        currentIndex = 0;
        currentWorkIndex = 0;

        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        description = findViewById(R.id.description);
        previous = findViewById(R.id.leftArrowButton);
        next = findViewById(R.id.rightArrowButton);
        image = findViewById(R.id.imageDisplay);

        title = findViewById(R.id.worktitle);
        workDescription = findViewById(R.id.workDescription);
        prevWork = findViewById(R.id.leftWorkButton);
        nextWork = findViewById(R.id.rightWorkButton);
        work = findViewById(R.id.workDisplay);

        showGallery();
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = increment(currentIndex);
                showGallery();
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentIndex = decrement(currentIndex);
                showGallery();
            }
        });

        nextWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentWorkIndex = increment(currentWorkIndex);
                showWork();
            }
        });

        prevWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentWorkIndex = decrement(currentWorkIndex);
                showWork();
            }
        });
    }
    public int increment(int input){
        return checkBounds(input+1);
    }
    public int decrement(int input){
        return checkBounds(input-1);
    }
    public void showWork(){
        currentWorkIndex = checkBounds(currentWorkIndex);
        Gallery Work = Collections[currentIndex][currentWorkIndex];
        workDescription.setText(Work.description);
        title.setText(Work.name);
        Drawable currImage = getResources().getDrawable(Work.ID);
        work.setImageDrawable(currImage);
    }
        public void showGallery(){
            currentIndex = checkBounds(currentIndex);
            Gallery current = galleries[currentIndex];
            description.setText(current.description);
            name.setText(current.name);
            Drawable currImage = getResources().getDrawable(current.ID);
            image.setImageDrawable(currImage);
            showWork();
        }
        public int checkBounds(int input) {
            if (input == -1) {
                return 2;
            }
            if (input == 3) {
                return 0;
            }
            return input;
        }
    }
