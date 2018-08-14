package com.example.imageapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.imageapp.models.ClevelandSportsCurse;

public class MainActivity extends AppCompatActivity {
    private int currentIndex;

    ClevelandSportsCurse[] curses = {
            new ClevelandSportsCurse("The Drive", R.drawable.the_drive,
                    "Against one of the best defenses in the league, John Elway led Denver on a 98-yard drive to tie the 1987 AFC Championship game with only seconds remaining in regulation. Denver then went on to win the game in overtime 23-20 on a field goal that some Browns fans, to this day, insist sailed wide of the upright."),
            new ClevelandSportsCurse("The Fumble", R.drawable.the_fumble,
                    "Browns running back Earnest Byner amassed an outstanding 187 total yards from scrimmage (67 rushing, 120 receiving) in the 1988 AFC Championship Game against Denver. However, he'll forever be remembered for a heart-wrenching fumble at Denver's three-yard line late in the fourth quarter. Byner had what seemed to be a clear path to the end zone to score what would have been a game-tying touchdown, and Cleveland had its heart broken again, just a year after John Elway did it with The Drive."),
            new ClevelandSportsCurse("The Shot", R.drawable.the_shot,
                    "The Bulls were 0 for 6 against the Cleveland Cavaliers in the 1988-89 regular season, but Michael Jordan stepped up when it mattered the most. In the deciding fifth game of their playoff series, Craig Ehlo scored on a layup to give Cleveland a one-point lead with three seconds remaining only to see Jordan (pictured in 1991) bury a series-deciding jumper over him on the final play of the game. "),
            new ClevelandSportsCurse("The Move", R.drawable.the_move,
                    "More than a decade has passed since \"The Move,\" but the name Art Modell still draws angry looks and responses when mentioned within Cleveland's city limits. His decision to move the storied Browns franchise to Baltimore, Md., for the start of the 1996 NFL season led to angry protests, lawsuits and ultimately the NFL allowing the team to keep its name, team colors and history intact for a new incarnation of the franchise three seasons later."),
            new ClevelandSportsCurse("1997 World Series", R.drawable.world_series,
                    "The Marlins tied Game 7 against Matt Williams (below) and the Indians in the bottom of the ninth, then went on to claim the game and series in the 11th. More recently, the Indians blew a 3-1 lead to the Boston Red Sox in the 2007 ALCS and still have not returned to the World Series since 1997. Cleveland has the second-longest World Series championship drought (1948) behind the Chicago Cubs."),
            new ClevelandSportsCurse("The Decision", R.drawable.the_decision,
                    "\"This fall I am taking my talents to South Beach and play with the Miami Heat. The major factor was the best opportunity for me to win, to win now and for the future also. Winning is the most important thing for me. I feel like this is going to be the best opportunity.\" — LeBron James, July 8, 2010")
    };

    private TextView page;
    private TextView name;
    private ImageView picture;
    private TextView description;
    private Button previous;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentIndex = 0;

        name = findViewById(R.id.name);
        picture = findViewById(R.id.picture);
        description = findViewById(R.id.description);

        previous = findViewById(R.id.previous);
        next = findViewById(R.id.next);

        String page = "currentIndex + 1 / curses.length";

        showCurse(currentIndex);

        previous.setOnClickListener(new View.OnClickListener() {
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

    public void increment() {
        currentIndex++;
        showCurse(currentIndex);
    }

    public void decrement() {
        currentIndex--;
        showCurse(currentIndex);
    }

    public void showCurse(int index) {
        preventBounds();

        ClevelandSportsCurse curse = curses[index];
        name.setText(curse.name);
        description.setText(curse.description);

        Drawable pic = getResources().getDrawable(curse.drawableId);
        picture.setImageDrawable(pic);
    }

    public void preventBounds() {
        next.setEnabled(true);
        previous.setEnabled(true);

        currentIndex = Math.max(currentIndex, 0);
        currentIndex = Math.min(currentIndex, curses.length - 1);

        if (currentIndex == curses.length - 1) {
            next.setEnabled(false);
        }

        if (currentIndex == 0) {
            previous.setEnabled(false);
        }
    }
}
