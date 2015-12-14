package com.example.einarsandberg.projekt;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.TextView;
import android.util.Log;
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
    PasswordStrengthMeter passwordStrengthMeter;
    EmailFeedback emailFeedback;

    EditText editEmail;
    TextView email;
    TextView address;
    EditText editAddress;
    public InputFeedback(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
        initLayout();
    }



    private void init()
    {
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
        editEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (emailFeedback.isEmailValid(s.toString()))
                {
                    editEmail.setBackgroundColor(Color.WHITE);
                }
                else
                {
                    editEmail.setBackgroundColor(Color.parseColor("#ff6666"));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

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


        addressParams.topMargin = 250;
        addressParams.addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);


        editAddressParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        editAddressParams.topMargin = 200;
        editAddressParams.leftMargin = 200;


        addView(email, emailParams);
        addView(editEmail, editEmailParams);
        addView(address, addressParams);
        addView(editAddress, editAddressParams);
        addView(passwordStrengthMeter);

    }
}
