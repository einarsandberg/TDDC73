package com.example.einarsandberg.projekt;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;
/**
 * Created by einarsandberg on 2015-12-11.
 */
public class InputFeedback extends RelativeLayout
{
    Context context;
    private final static String TAG = "InputFeedback";
    RelativeLayout.LayoutParams relativeParams;
    RelativeLayout.LayoutParams emailParams;
    RelativeLayout.LayoutParams editEmailParams;
    RelativeLayout.LayoutParams addressParams;
    RelativeLayout.LayoutParams editAddressParams;
    RelativeLayout.LayoutParams buttonParams;
    PasswordStrengthMeter passwordStrengthMeter;
    EmailFeedback emailFeedback;
    AddressFeedback addressFeedback;

    EditText editEmail;
    TextView email;
    TextView address;
    EditText editAddress;
    Button button;
    private boolean validEmail;
    private boolean validAddress;
    private boolean validPassword;
    public InputFeedback(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
        initLayout();
    }



    private void init()
    {
        validEmail = false;
        validAddress = false;
        validPassword = false;
        button = new Button(context);
        button.setText("Register");
        email = new TextView(context);
        email.setText("Email");
        email.setId(1);
        editEmail = new EditText(context);
        editEmail.setId(2);
        address = new TextView(context);
        address.setText("Address");
        address.setId(3);
        editAddress = new EditText(context);
        editAddress.setId(4);

        passwordStrengthMeter = new PasswordStrengthMeter(context);
        emailFeedback = new EmailFeedback(context);
        addressFeedback = new AddressFeedback();
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (emailFeedback.isEmailValid(s.toString()))
                {
                    editEmail.setBackgroundColor(Color.parseColor("#99cc00"));
                    validEmail = true;
                }
                else
                {
                    editEmail.setBackgroundColor(Color.parseColor("#ff6666"));
                    validEmail = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        editAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (addressFeedback.isAddressValid(s.toString()))
                {
                    editAddress.setBackgroundColor(Color.parseColor("#99cc00"));
                    validAddress = true;
                }
                else
                {
                    editAddress.setBackgroundColor(Color.parseColor("#ff6666"));
                    validAddress = false;
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (validAddress && validEmail && !passwordStrengthMeter.getValidPassword().equals(""))
                {
                    Account account = new Account(editEmail.getText().toString(), editAddress.getText().toString(),
                            passwordStrengthMeter.getValidPassword());
                    account.print();
                }
            }
        });


    }
    private void initLayout()
    {

        relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        this.setLayoutParams(relativeParams);

        emailParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        emailParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
        emailParams.topMargin = 50;

        editEmailParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

       // editEmailParams.topMargin = 50;
        editEmailParams.leftMargin = 200;

        addressParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);


        addressParams.topMargin = 300;
        addressParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);


        editAddressParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        editAddressParams.topMargin = 250;
        editAddressParams.leftMargin = 200;

        buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.topMargin = 900;
        buttonParams.rightMargin = 500;
        buttonParams.leftMargin = 500;


        addView(email, emailParams);
        addView(editEmail, editEmailParams);
        addView(address, addressParams);
        addView(editAddress, editAddressParams);
        addView(passwordStrengthMeter);
        addView(button, buttonParams);

    }
}
