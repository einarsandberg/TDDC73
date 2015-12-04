package com.example.einarsandberg.projekt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.EditText;
import android.util.Log;
/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthMeter extends LinearLayout
{
    private static final String TAG = "PasswordStrengthMeter";
    EditText passwordField;
    Context context;
    LinearLayout.LayoutParams fieldParams;
    private PasswordStrengthBar pwBar;
    private PasswordAlgorithm pwAlgorithm;
    public PasswordStrengthMeter(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
    }
    public void init()
    {
        this.setOrientation(VERTICAL);

        pwBar = new PasswordStrengthBar(context, null, android.R.attr.progressBarStyleHorizontal);
        pwBar.setBar("Too short", 20);
        fieldParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        pwAlgorithm = new PasswordAlgorithm();
        passwordField = new EditText(context);
        passwordField.setLayoutParams(fieldParams);
        passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "HEJJJJJ");
                pwBar.invalidate(); // draw bar again with new strength
                pwBar.setBar(pwAlgorithm.getStrengthLevel(s.toString()),
                        getProgress(pwAlgorithm.getStrengthLevel(s.toString())));
                Log.d(TAG, pwAlgorithm.getStrengthLevel(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        addView(passwordField);
        addView(pwBar);
    }
    private int getProgress(String strengthLevel)
    {
        switch (strengthLevel)
        {
            case "Too short":
                return 20;

            case "Very weak":
                return 40;

            case "Weak":
                return 60;

            case "Strong":
                return 80;

            case "Very strong":
                return 100;

        }
        return 0;
    }
}
