package com.example.einarsandberg.projekt;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.GridLayout;
public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;
    PasswordStrengthMeter passwordStrengthMeter;
    EditText editUserName;
    TextView userName;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        linearLayout = new LinearLayout(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        userName = new TextView(this);
        password = new TextView(this);
        userName.setText("Username: ");
        password.setText("Password: ");
        editUserName = new EditText(this);


        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setRowCount(2);
        gridLayout.setColumnCount(2);
        GridLayout.Spec row1 = GridLayout.spec(0);
        GridLayout.Spec row2 = GridLayout.spec(1);
        GridLayout.Spec col1 = GridLayout.spec(0);
        GridLayout.Spec col2 = GridLayout.spec(1);

        GridLayout.LayoutParams obj1 = new GridLayout.LayoutParams(row1, col1);
        obj1.width = GridLayout.LayoutParams.WRAP_CONTENT;

        GridLayout.LayoutParams obj2 = new GridLayout.LayoutParams(row1,col2);
        obj2.width = GridLayout.LayoutParams.MATCH_PARENT;

        GridLayout.LayoutParams obj3 = new GridLayout.LayoutParams(row2,col1);
        obj3.width = GridLayout.LayoutParams.WRAP_CONTENT;

        GridLayout.LayoutParams obj4 = new GridLayout.LayoutParams(row2,col2);
        obj4.width = GridLayout.LayoutParams.MATCH_PARENT;

        gridLayout.addView(userName, obj1);
        gridLayout.addView(editUserName, obj2);
        gridLayout.addView(password, obj3);
        gridLayout.addView(passwordStrengthMeter, obj4);





        linearLayout.addView(gridLayout);
        setContentView(linearLayout);

    }
}
