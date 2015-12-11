package com.example.einarsandberg.projekt;

import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.TextView;

/**
 * Created by einarsandberg on 2015-12-11.
 */
public class InputFeedback extends RelativeLayout
{
    Context context;
    RelativeLayout.LayoutParams relativeParams;
    RelativeLayout.LayoutParams emailParams;
    RelativeLayout.LayoutParams editEmailParams;
    RelativeLayout.LayoutParams addressParams;
    RelativeLayout.LayoutParams editAddressParams;
    PasswordStrengthMeter passwordStrengthMeter;


    EditText editEmail;
    TextView email;
    TextView address;
    EditText editAddress;
    public InputFeedback(Context theContext)
    {
        super(theContext);
        context = theContext;
        initComponents();
        initLayout();

    }
    private void initComponents()
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
