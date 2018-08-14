package com.android.sooz.arrayimage;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.sooz.arrayimage.models.Projects;

public class MainActivity extends AppCompatActivity {
    private int currentIndex;
    Projects[] projects= {
        new Projects("Molly Hat", R.drawable.mollyhat, "Hat", "Erin Ruth", "https://www.ravelry.com/patterns/library/molly-9"),
        new Projects("Magic Brioche", R.drawable.magicbriochehat, "Hat", "Katrin Schubert", "https://www.ravelry.com/patterns/library/magic-brioche"),
        new Projects("A Walk Through Aspens", R.drawable.aspenswrap, "Wrap", "Kularah Hudson", "https://www.ravelry.com/patterns/library/a-walk-through-aspens"),
        new Projects("Wonder Woman Wrap", R.drawable.wwshawl, "Shawl", "Carissa Browning", "https://www.ravelry.com/patterns/library/wonder-woman-wrap-knit"),
        new Projects("Whiskyfied", R.drawable.whiskyfiedshawl, "Shawl", "Melanie Berg", "https://www.ravelry.com/patterns/library/whiskyfied"),
    };

    //variables for content on each app page/view
    private ImageView picture;
    private TextView name;
    private TextView type;
    private TextView designer;
    private TextView patternLink;

    //variables for app buttons to view each project
    private Button prev;
    private Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //counter of projects to help with app navigation between project image views
        currentIndex = 0;

        //render an object of the Project class in an app view/page
        picture = findViewById(R.id.picture);
        name = findViewById(R.id.name);
        type = findViewById(R.id.type);
        designer = findViewById(R.id.designer);
        patternLink = findViewById(R.id.patternLink);

        //help from TA Casey Cady and StackOverflow
        //https://stackoverflow.com/questions/2734270/how-do-i-make-links-in-a-textview-clickable
//        TextView patternLink = (TextView) findViewById(R.id.patternLink);
//        patternLink.setMovementMethod(LinkMovementMethod.getInstance());

        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);

        //render single project object page/view
        showProject();

        //when previous button is clicked on, decrement counter and go to prior project view
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decrement();
            }
        });


        //when previous button is clicked on, increment counter and go to next project view
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                increment();
            }
        });
    }

    public void increment(){
        currentIndex ++;
        showProject();
    }

    public void decrement(){
        currentIndex --;
        showProject();

    }
    //creates single project page/view within app
    public void showProject(){

        //allows user to cycle through projects on a loop
        cycleBounds();

        Projects project = projects[currentIndex];
        name.setText(project.name);
        type.setText(project.type);
        designer.setText(project.designer);
        patternLink.setText(project.patternLink);

        Drawable pic = getResources().getDrawable(project.drawableID);
        picture.setImageDrawable(pic);

    }

    //directly from lecture & demo
    public void cycleBounds() {
        // assume the best
        next.setEnabled(true);
        prev.setEnabled(true);

        if (currentIndex < 0) {
            currentIndex = projects.length - 1;
        } else {
            currentIndex = currentIndex % projects.length;
        }

    }
}
