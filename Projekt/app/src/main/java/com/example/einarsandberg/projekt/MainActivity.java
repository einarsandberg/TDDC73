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

        AlgorithmFactory algorithmFactory = new AlgorithmFactory();
        linearLayout = new LinearLayout(this);
        List<AccountParameter> params = new ArrayList<AccountParameter>();
        params.add(new AccountParameter("Email"));
        params.add(new AccountParameter("Address"));
        params.add(new AccountParameter("Name"));
        params.add(new AccountParameter("Password"));
        params.get(0).setAlgorithm(algorithmFactory.getAlgorithm(params.get(0).getName()));

        params.get(1).setAlgorithm(algorithmFactory.getAlgorithm(params.get(1).getName()));
        params.get(3).setAlgorithm(algorithmFactory.getAlgorithm(params.get(3).getName()));
        inputFeedback = new InputFeedback(this, params);

        linearLayout.addView(inputFeedback);
        setContentView(linearLayout);

    }
}
