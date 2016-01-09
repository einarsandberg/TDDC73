package com.example.einarsandberg.projekt;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.einarsandberg.projekt.InputFeedback.Algorithm.AlgorithmFactory;
import com.example.einarsandberg.projekt.InputFeedback.InputFeedback;

import java.util.List;
import java.util.ArrayList;

/**
 *  By setting useInputFeedback and useAccountRegistration to true or false,
 *  you specify if you want to use any or both or none of these functions.
 *
 *  If you want to add a new parameter, say a Name parameter, simply add it to
 *  the list, params. If there is an algorithm and visualization method, available for that parameter,
 *  it will be used, if useInputFeedback == true.
 *
 *  To add a parameter with a new algorithm and visualization method, follow these steps:
 *
 *  1. Set InputFeedback = true and add the parameter (e.g "Name") to params.
 *  2. Create the new algorithm (e.g NameAlgorithm), implementing the FieldAlgorithmInterface.
 *  3. Add a new if-statement to the getAlgorithm() function in AlgorithmFactory, to create the new algorithm.
 *  4. Create the new visualization class, implementing the VisualizationMethod interface.
 *  5. Add a new static String with the visualization type to the InputFeedback class, and add another if-statement
 *     to the function initVisualizationTypes().
 *  6. Add the new visualization type to VisualizationFactory
 *
 *
 */
public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;
    InputFeedback inputFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        boolean useInputFeedback = true;
        boolean useAccountRegistration = true;

        linearLayout = new LinearLayout(this);
        List<AccountParameter> params = new ArrayList<AccountParameter>();
        params.add(new AccountParameter("Email"));
      //  params.add(new AccountParameter("Name"));
      // params.add(new AccountParameter("TJOHEJ"));
        params.add(new AccountParameter("Address"));
        params.add(new AccountParameter("Password"));
       // params.add(new AccountParameter("Name"));
        FlexibleForm flexibleForm = new FlexibleForm(this, params, useInputFeedback, useAccountRegistration);
       // inputFeedback = new InputFeedback(this, params);

        linearLayout.addView(flexibleForm);
        setContentView(linearLayout);

    }
}
