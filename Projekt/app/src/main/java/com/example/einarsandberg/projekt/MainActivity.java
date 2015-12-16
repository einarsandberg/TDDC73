package com.example.einarsandberg.projekt;

import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.List;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;
    InputFeedback inputFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        linearLayout = new LinearLayout(this);
        List<AccountParameter> paramList = new ArrayList<AccountParameter>();
        paramList.add(new AccountParameter("Email"));
        paramList.add(new AccountParameter("Address"));
        paramList.add(new AccountParameter("Password"));
        paramList.get(0).setAlgorithmState(true);
        paramList.get(1).setAlgorithmState(true);
        paramList.get(2).setAlgorithmState(true);
        inputFeedback = new InputFeedback(this, paramList);

        linearLayout.addView(inputFeedback);
        setContentView(linearLayout);

    }
}
