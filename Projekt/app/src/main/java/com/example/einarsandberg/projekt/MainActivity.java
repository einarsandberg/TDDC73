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

        inputFeedback = new InputFeedback(this, paramList);
        /*userName = new TextView(this);
        userName.setText("Username");
        userName.setId(1);
        editUserName = new EditText(this);

        linearLayout = new LinearLayout(this);
        relativeLayout = new RelativeLayout(this);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        passwordStrengthMeter = new PasswordStrengthMeter(this);

        relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(relativeParams);

        userNameParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        userNameParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
        userNameParams.topMargin = 50;

        editUserNameParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        editUserNameParams.addRule(RelativeLayout.RIGHT_OF, userName.getId());


        relativeLayout.addView(userName, userNameParams);
        relativeLayout.addView(editUserName, editUserNameParams);
        relativeLayout.addView(passwordStrengthMeter);*/
        linearLayout.addView(inputFeedback);
        setContentView(linearLayout);

    }
}
