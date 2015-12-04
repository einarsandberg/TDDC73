package com.example.einarsandberg.projekt;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.EditText;
/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthMeter extends LinearLayout
{
    EditText passwordField;
    Context context;
    LinearLayout.LayoutParams fieldParams;
    PasswordStrengthBar pwBar;
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
        fieldParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);

        passwordField = new EditText(context);
        passwordField.setLayoutParams(fieldParams);
        passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        addView(passwordField);
        addView(pwBar);
    }
}
