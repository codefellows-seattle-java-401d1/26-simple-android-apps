package com.example.imageapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.imageapp.models.ClevelandSportsCurse;

public class MainActivity extends AppCompatActivity {
    ClevelandSportsCurse[] curses = {
            new ClevelandSportsCurse("The Drive",
                    "Against one of the best defenses in the league, John Elway led Denver on a 98-yard drive to tie the 1987 AFC Championship game with only seconds remaining in regulation. Denver then went on to win the game in overtime 23-20 on a field goal that some Browns fans, to this day, insist sailed wide of the upright."),
            new ClevelandSportsCurse("The Fumble",
                    "Browns running back Earnest Byner amassed an outstanding 187 total yards from scrimmage (67 rushing, 120 receiving) in the 1988 AFC Championship Game against Denver. However, he'll forever be remembered for a heart-wrenching fumble at Denver's three-yard line late in the fourth quarter. Byner had what seemed to be a clear path to the end zone to score what would have been a game-tying touchdown, and Cleveland had its heart broken again, just a year after John Elway did it with The Drive."),
            new ClevelandSportsCurse("The Shot",
                    "The Bulls were 0 for 6 against the Cleveland Cavaliers in the 1988-89 regular season, but Michael Jordan stepped up when it mattered the most. In the deciding fifth game of their playoff series, Craig Ehlo scored on a layup to give Cleveland a one-point lead with three seconds remaining only to see Jordan (pictured in 1991) bury a series-deciding jumper over him on the final play of the game. "),
            new ClevelandSportsCurse("The Move",
                    "More than a decade has passed since \"The Move,\" but the name Art Modell still draws angry looks and responses when mentioned within Cleveland's city limits. His decision to move the storied Browns franchise to Baltimore, Md., for the start of the 1996 NFL season led to angry protests, lawsuits and ultimately the NFL allowing the team to keep its name, team colors and history intact for a new incarnation of the franchise three seasons later."),
            new ClevelandSportsCurse("1997 World Series",
                    "The Marlins tied Game 7 against Matt Williams (below) and the Indians in the bottom of the ninth, then went on to claim the game and series in the 11th. More recently, the Indians blew a 3-1 lead to the Boston Red Sox in the 2007 ALCS and still have not returned to the World Series since 1997. Cleveland has the second-longest World Series championship drought (1948) behind the Chicago Cubs."),
            new ClevelandSportsCurse("The Decision",
                    "\"This fall I am taking my talents to South Beach and play with the Miami Heat. The major factor was the best opportunity for me to win, to win now and for the future also. Winning is the most important thing for me. I feel like this is going to be the best opportunity.\" — LeBron James, July 8, 2010")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
