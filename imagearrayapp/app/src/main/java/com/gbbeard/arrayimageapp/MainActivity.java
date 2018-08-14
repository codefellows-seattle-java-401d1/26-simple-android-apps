package com.gbbeard.arrayimageapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.gbbeard.arrayimageapp.models.MusicGenre;

public class MainActivity extends AppCompatActivity {
    private int currentIndex;
    private int itemInArray;

    MusicGenre[] genres = {
            new MusicGenre("Experimental", R.drawable.blackdice,
                    "A genre as wide as it is deep. Experimental music is a catch all term for a diverse style of modifiers for other genres and as a genre in and of itself. Experimental music whether from the likes of John Cage, Captain Beefhart, Zappa or Black Dice continues to evolve and change with the era."),
            new MusicGenre("Neo-Psychedelic", R.drawable.animalcollective,
                    "Neo-Psychedelic is a genre drawing from the rich tradition of psychedelic rock but with modern twists. Often involving visual and interactive elements beyond normal psychedelic rock. Neo Psychedelic often uses sampling and heavy use of different modulation to create trippy music"),
            new MusicGenre("Garage Rock", R.drawable.deerhunter,
                    "Garage Rock as a genre comes out of the tendency for many bands to come up with a garage sound, that is to say, loud, energetic and raw. Later evolutions of garage rock like deerhunter have incorporated newer developments in music gear to create high energy and diverse performance beyond simple garage guitar shredding"),
            new MusicGenre("Avant Pop", R.drawable.bjork,
                    "Avant Pop is a synthesis of experimental music, avant garde art, and pop music. Often combining the style and structure of pop socks with more experimental attempts in sound and art. Avant Pop such as Bjork pushes the boundaries of what is considered pop while maintaining a uniqueness that is not easily replicated by other pop artists."),
    };

    private ImageView picture;
    private TextView name;
    private TextView desc;
    private TextView itemsIn;


    private Button prev;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentIndex = 0;
        itemInArray = currentIndex + 1;


        picture = findViewById(R.id.picture);
        name = findViewById(R.id.name);
        desc = findViewById(R.id.description);
        itemsIn = findViewById(R.id.itemsIn);

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        showGenre();

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
        itemInArray++;
        showGenre();
    }

    public void decrement() {
        currentIndex--;
        itemInArray--;
        showGenre();
    }

    public void showGenre() {
        cycleBounds();

        MusicGenre genre = genres[currentIndex];
        name.setText(genre.name);
        desc.setText(genre.description);
        itemsIn.setText(itemInArray + " of 4");

        Drawable pic = getResources().getDrawable(genre.drawableId);
        picture.setImageDrawable(pic);
    }

    public void cycleBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = genres.length - 1;
        } else {
            currentIndex = currentIndex % genres.length;
        }
    }

    public void preventBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        // guarantee the current index is between zero and the length of the array
        currentIndex = Math.max(currentIndex, 0);
        currentIndex = Math.min(currentIndex, genres.length - 1);

        // deal with the worst
        if (currentIndex == genres.length - 1) {
            next.setEnabled(false);
        }

        if (currentIndex == 0) {
            prev.setEnabled(false);
        }

    }
}