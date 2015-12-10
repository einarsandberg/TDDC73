package com.example.einarsandberg.projekt;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.content.Context;
import android.widget.EditText;
import android.util.Log;
import android.widget.TextView;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.view.Gravity;
/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthMeter extends RelativeLayout
{
    private static final String TAG = "PasswordStrengthMeter";
    EditText passwordField;
    TextView password;
    Context context;
    RelativeLayout.LayoutParams fieldParams;
    RelativeLayout.LayoutParams passwordParams;
    RelativeLayout.LayoutParams barParams;
    RelativeLayout.LayoutParams buttonParams;
    private PasswordStrengthBar pwBar;
    private PasswordAlgorithmInterface pwAlgorithm;
    Button button;
    public PasswordStrengthMeter(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
        this.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT));
    }
    public void init()
    {
        button = new Button(context);
        button.setText("Submit");
        password = new TextView(context);
        password.setText("Password");
        password.setId(3);
        pwBar = new PasswordStrengthBar(context, null, android.R.attr.progressBarStyleHorizontal);

        pwBar.setBar("Too short", 20);

        passwordParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        passwordParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
        passwordParams.topMargin = 200;

        fieldParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        fieldParams.addRule(RelativeLayout.RIGHT_OF, password.getId());
        fieldParams.topMargin = 150;

        pwAlgorithm = new PasswordAlgorithm();
        passwordField = new EditText(context);
        passwordField.setLayoutParams(fieldParams);
        barParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        pwBar.setLayoutParams(barParams);
        barParams.addRule(RelativeLayout.BELOW, password.getId());
        barParams.topMargin = 100;

        buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.topMargin = 500;
        buttonParams.rightMargin = 500;
        buttonParams.leftMargin = 500;



        passwordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(TAG, "HEJJJJJ");
                pwBar.invalidate(); // must draw bar again with new strength
                pwBar.setBar(pwAlgorithm.getStrengthLevel(s.toString()),
                        pwAlgorithm.getProgress(pwAlgorithm.getStrengthLevel(s.toString())));
                Log.d(TAG, pwAlgorithm.getStrengthLevel(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        addView(password, passwordParams);
        addView(passwordField, fieldParams);
        addView(pwBar, barParams);
        addView(button, buttonParams);
    }

}
