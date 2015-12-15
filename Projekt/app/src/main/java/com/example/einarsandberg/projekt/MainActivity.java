package com.example.einarsandberg.projekt;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RelativeLayout;
import java.util.List;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;
    RelativeLayout relativeLayout;
    RelativeLayout.LayoutParams relativeParams;
    RelativeLayout.LayoutParams userNameParams;
    RelativeLayout.LayoutParams editUserNameParams;
    PasswordStrengthMeter passwordStrengthMeter;
    RelativeLayout.LayoutParams meterParams;
    InputFeedback inputFeedback;
    EditText editUserName;
    TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        linearLayout = new LinearLayout(this);
        List<AccountParameter> paramList = new ArrayList<AccountParameter>();
        paramList.add(new AccountParameter("Email"));
        paramList.add(new AccountParameter("Address"));
        paramList.get(0).setAlgorithmState(true);
        paramList.get(1).setAlgorithmState(false);
        inputFeedback = new InputFeedback(this, paramList);

        linearLayout.addView(inputFeedback);
        setContentView(linearLayout);

    }
}
