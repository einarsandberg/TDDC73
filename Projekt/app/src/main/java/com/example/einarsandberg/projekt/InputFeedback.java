package com.example.einarsandberg.projekt;

import android.graphics.Color;
import android.text.Editable;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Context;
import android.widget.TextView;
import android.util.Log;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
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

    List<TextView> textViewList;
    List<EditText> editTextList;
    List<LayoutParams> layoutTextViewList;
    List<LayoutParams> layoutEditTextList;
    private int lastTextViewTopMargin;
    private int lastEditTextTopMargin;

    List<AccountParameter> params;
    private int lastParameterPosition;
    private final static int MARGIN_TOP_BETWEEN_TEXTVIEW = 250;
    private final static int MARGIN_TOP_BETWEEN_EDITTEXT = 250;
    private final static int LEFT_MARGIN_EDITTEXT = 200;

    EditText editEmail;
    TextView email;
    TextView address;
    EditText editAddress;
    Button button;
    private boolean validEmail;
    private boolean validAddress;
    private boolean validPassword;
    public InputFeedback(Context theContext, List<AccountParameter> theParams)
    {
        super(theContext);
        context = theContext;
        lastTextViewTopMargin = 50;
        lastEditTextTopMargin = 0;
        params = new ArrayList<AccountParameter>();
        params = theParams;
        init();
        initLayout();


    }

    private void init()
    {

        textViewList = new ArrayList<TextView>();
        editTextList = new ArrayList<EditText>();
        layoutTextViewList = new ArrayList<LayoutParams>();
        layoutEditTextList = new ArrayList<LayoutParams>();
        for (int i = 0; i < params.size(); i++)
        {

            textViewList.add(new TextView(context));
            textViewList.get(i).setText(params.get(i).getName());
            Log.d(TAG, params.get(i).toString());
            editTextList.add(new EditText(context));
        }
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
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (addressFeedback.isAddressValid(s.toString())) {
                    editAddress.setBackgroundColor(Color.parseColor("#99cc00"));
                    validAddress = true;
                } else {
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
            public void onClick(View v) {
                if (validAddress && validEmail && !passwordStrengthMeter.getValidPassword().equals("")) {
                    Account account = new Account(editEmail.getText().toString(), editAddress.getText().toString(),
                            passwordStrengthMeter.getValidPassword());
                    account.print();
                }
            }
        });
       // initLayout();

    }
    private void initLayout()
    {
        relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT);

        this.setLayoutParams(relativeParams);

        for (int i = 0; i < textViewList.size(); i++)
        {
            layoutTextViewList.add(new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT));
            layoutTextViewList.get(i).addRule(RelativeLayout.ALIGN_LEFT, RelativeLayout.TRUE);
            layoutTextViewList.get(i).topMargin = lastTextViewTopMargin;
            lastTextViewTopMargin = lastTextViewTopMargin + MARGIN_TOP_BETWEEN_TEXTVIEW;

            textViewList.get(i).setLayoutParams(layoutTextViewList.get(i));

            layoutEditTextList.add(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
            layoutEditTextList.get(i).leftMargin = LEFT_MARGIN_EDITTEXT;
            layoutEditTextList.get(i).topMargin = lastEditTextTopMargin;
            editTextList.get(i).setLayoutParams(layoutEditTextList.get(i));
            lastEditTextTopMargin = lastEditTextTopMargin + MARGIN_TOP_BETWEEN_EDITTEXT;
            addView(textViewList.get(i));
            addView(editTextList.get(i));
        }



        /*emailParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
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
        editAddressParams.leftMargin = 200;*/

        buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.topMargin = 900;
        buttonParams.rightMargin = 500;
        buttonParams.leftMargin = 500;


       /* addView(email, emailParams);
        addView(editEmail, editEmailParams);
        addView(address, addressParams);*
        addView(editAddress, editAddressParams);*/
        addView(passwordStrengthMeter);
        addView(button, buttonParams);

    }
}
