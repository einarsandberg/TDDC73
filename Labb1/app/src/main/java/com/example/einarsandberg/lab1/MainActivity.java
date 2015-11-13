package com.example.einarsandberg.lab1;


import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.text.method.PasswordTransformationMethod;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

         // 1.1

        /*LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        Toolbar toolbar = new Toolbar(this);
        toolbar.setTitle("Laboration 1.1");
        toolbar.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        toolbar.setBackgroundColor(Color.parseColor("#78909C"));
        setSupportActionBar(toolbar);

        Button button = new Button(this);
        button.setText("KNAPP");
        button.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));

        EditText singleLineField = new EditText(this);
        singleLineField.setSingleLine(true);

        RatingBar ratingBar = new RatingBar(this);

        LinearLayout.LayoutParams ratingParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        ratingParams.gravity = Gravity.CENTER_HORIZONTAL;
        ratingBar.setLayoutParams(ratingParams);
        ratingBar.setNumStars(5);

        EditText multipleLineField = new EditText(this);

        LinearLayout.LayoutParams multLineParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);

        multipleLineField.setLayoutParams(multLineParams);


        multipleLineField.setMovementMethod(null);

        layout.addView(toolbar);
        layout.addView(button);
        layout.addView(singleLineField);
        layout.addView(ratingBar);
        layout.addView(multipleLineField);
        setContentView(layout);
         */

        // 1.2

       /* LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(4);
        gridLayout.setColumnCount(2);
        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);
        GridLayout.Spec row3 = GridLayout.spec(2);
        GridLayout.Spec row4= GridLayout.spec(3);

        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);

        Toolbar toolbar = new Toolbar(this);
        toolbar.setTitle("Laboration 1.2");
        toolbar.setBackgroundColor(Color.parseColor("#78909C"));
        setSupportActionBar(toolbar);
        toolbar.setLayoutParams(new Toolbar.LayoutParams(Toolbar.LayoutParams.MATCH_PARENT,
                Toolbar.LayoutParams.WRAP_CONTENT));

        TextView name, password, email, age;

        name = new TextView(this);
        password = new TextView(this);
        email = new TextView(this);
        age = new TextView(this);

        name.setText("Namn");
        password.setText("Lösenord");
        email.setText("Email");
        age.setText("Ålder");

        EditText editPassword, editName, editEmail;

        editName = new EditText(this);
        editPassword = new EditText(this);
        editEmail = new EditText(this);

        editPassword.setTransformationMethod(new PasswordTransformationMethod());

        editName.setWidth(GridLayout.LayoutParams.MATCH_PARENT);
        editPassword.setWidth(GridLayout.LayoutParams.MATCH_PARENT);
        editEmail.setWidth(GridLayout.LayoutParams.MATCH_PARENT);

        SeekBar ageBar = new SeekBar(this);

        // set correct positions
        // row 1
        GridLayout.LayoutParams obj1 = new GridLayout.LayoutParams(row1,col1);
        obj1.width = GridLayout.LayoutParams.WRAP_CONTENT;
        GridLayout.LayoutParams obj2 = new GridLayout.LayoutParams(row1,col2);
        obj2.width = GridLayout.LayoutParams.MATCH_PARENT;

        //row 2
        GridLayout.LayoutParams obj3 = new GridLayout.LayoutParams(row2,col1);
        obj3.width = GridLayout.LayoutParams.WRAP_CONTENT;
        GridLayout.LayoutParams obj4 = new GridLayout.LayoutParams(row2,col2);
        obj4.width = GridLayout.LayoutParams.MATCH_PARENT;

        //row 3
        GridLayout.LayoutParams obj5 = new GridLayout.LayoutParams(row3,col1);
        obj5.width = GridLayout.LayoutParams.WRAP_CONTENT;
        GridLayout.LayoutParams obj6 = new GridLayout.LayoutParams(row3,col2);
        obj6.width = GridLayout.LayoutParams.MATCH_PARENT;

        //row 4
        GridLayout.LayoutParams obj7 = new GridLayout.LayoutParams(row4,col1);
        obj7.width = GridLayout.LayoutParams.WRAP_CONTENT;
        GridLayout.LayoutParams obj8 = new GridLayout.LayoutParams(row4,col2);
        obj8.width = GridLayout.LayoutParams.MATCH_PARENT;

        gridLayout.addView(name, obj1);
        gridLayout.addView(editName, obj2);
        gridLayout.addView(password, obj3);
        gridLayout.addView(editPassword, obj4);
        gridLayout.addView(email,obj5);
        gridLayout.addView(editEmail, obj6);
        gridLayout.addView(age, obj7);
        gridLayout.addView(ageBar, obj8);


        linearLayout.addView(toolbar);
        linearLayout.addView(gridLayout);
        setContentView(linearLayout);*/

        // 1.3

        // http://justsimpleinfo.blogspot.se/2014/05/android-relativelayout-example.html


       /* RelativeLayout relativeLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT
        );

        relativeLayout.setLayoutParams(params);*/

        LinearLayout linearLayout = new LinearLayout(this);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        );
        linearLayout.setLayoutParams(params);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        RelativeLayout relativeLayout = new RelativeLayout(this);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        Toolbar toolbar = new Toolbar(this);
        toolbar.setTitle("Laboration 1.3");
        toolbar.setBackgroundColor(Color.parseColor("#78909C"));
        setSupportActionBar(toolbar);

        LinearLayout.LayoutParams barParams = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );


        TextView question1, question2, question3;
        CheckBox goodBox, veryGoodBox, greatBox, yesBox1, noBox1, yesBox2, noBox2;
        Button submit;



        ImageView logo = new ImageView(this);

        logo.setImageResource(R.drawable.liu);








        goodBox = new CheckBox(this);
        veryGoodBox = new CheckBox(this);
        greatBox = new CheckBox(this);
        yesBox1 = new CheckBox(this);
        noBox1 = new CheckBox(this);
        yesBox2 = new CheckBox(this);
        noBox2 = new CheckBox(this);

        question1 = new TextView(this);
        question2 = new TextView(this);
        question3 = new TextView(this);
        question1.setText("Hur trivs du på LiU?");
        question2.setText("Läser du på LiTH?");
        question3.setText("Är detta LiUs logotyp?");

        goodBox.setText("Bra");
        veryGoodBox.setText("Mycket bra");
        greatBox.setText("Jättebra");
        yesBox1.setText("Ja");
        yesBox2.setText("Ja");
        noBox1.setText("Nej");
        noBox2.setText("Nej");


        submit = new Button(this);
        submit.setText("Skicka in");

        toolbar.setId(0);
        question1.setId(1);
        goodBox.setId(2);
        veryGoodBox.setId(3);
        greatBox.setId(4);
        question2.setId(5);
        yesBox1.setId(6);
        noBox1.setId(7);
        logo.setId(8);
        question3.setId(9);
        yesBox2.setId(10);
        noBox2.setId(11);



        RelativeLayout.LayoutParams questionParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        questionParams.addRule(RelativeLayout.BELOW, toolbar.getId());
        questionParams.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams goodBoxParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );
        goodBoxParams.addRule(RelativeLayout.BELOW, question1.getId());
        goodBoxParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams veryGoodBoxParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        veryGoodBoxParams.addRule(RelativeLayout.BELOW, question1.getId());
        veryGoodBoxParams.addRule(RelativeLayout.RIGHT_OF, goodBox.getId());

        RelativeLayout.LayoutParams greatBoxParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        greatBoxParams.addRule(RelativeLayout.BELOW, question1.getId());
        greatBoxParams.addRule(RelativeLayout.RIGHT_OF, veryGoodBox.getId());


        RelativeLayout.LayoutParams question2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        question2Params.addRule(RelativeLayout.BELOW, goodBox.getId());
        question2Params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);


        RelativeLayout.LayoutParams yesBox1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        yesBox1Params.addRule(RelativeLayout.BELOW, question2.getId());
        yesBox1Params.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);

        RelativeLayout.LayoutParams noBox1Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        noBox1Params.addRule(RelativeLayout.BELOW, question2.getId());
        noBox1Params.addRule(RelativeLayout.RIGHT_OF, yesBox1.getId());

        RelativeLayout.LayoutParams logoParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        logoParams.addRule(RelativeLayout.BELOW, noBox1.getId());
        logoParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams question3Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        question3Params.addRule(RelativeLayout.BELOW, logo.getId());
        question3Params.addRule(RelativeLayout.CENTER_HORIZONTAL);

        RelativeLayout.LayoutParams yesBox2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        yesBox2Params.addRule(RelativeLayout.BELOW, question3.getId());
        yesBox2Params.addRule(RelativeLayout.ALIGN_LEFT);

        RelativeLayout.LayoutParams noBox2Params = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        noBox2Params.addRule(RelativeLayout.BELOW, question3.getId());
        noBox2Params.addRule(RelativeLayout.RIGHT_OF, yesBox2.getId());

        RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        buttonParams.addRule(RelativeLayout.BELOW, noBox2.getId());
        question3Params.addRule(RelativeLayout.CENTER_HORIZONTAL);




        linearLayout.addView(toolbar, barParams);
        relativeLayout.addView(question1, questionParams);
        relativeLayout.addView(goodBox, goodBoxParams);
        relativeLayout.addView(veryGoodBox, veryGoodBoxParams);
        relativeLayout.addView(greatBox, greatBoxParams);
        relativeLayout.addView(question2, question2Params);
        relativeLayout.addView(yesBox1, yesBox1Params);
        relativeLayout.addView(noBox1, noBox1Params);
        relativeLayout.addView(logo, logoParams);
        relativeLayout.addView(question3, question3Params);
        relativeLayout.addView(yesBox2, yesBox2Params);
        relativeLayout.addView(noBox2, noBox2Params);
        relativeLayout.addView(submit, buttonParams);
        linearLayout.addView(relativeLayout);
        setContentView(linearLayout);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
