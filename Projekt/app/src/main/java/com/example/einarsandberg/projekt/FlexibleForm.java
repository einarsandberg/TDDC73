package com.example.einarsandberg.projekt;
import android.content.Context;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.einarsandberg.projekt.AccountRegistration.AccountRegistration;
import com.example.einarsandberg.projekt.InputFeedback.InputFeedback;

import java.util.ArrayList;
import java.util.List;
import android.view.View;
/**
 * Created by einarsandberg on 2016-01-08.
 */

/**
 *  This class creates a form given the parameters from MainActivity, with the correct layout.
 *
 *  It also uses InputFeedback and/or AccountRegistration given the instructions from MainActivity.
 *
 */
public class FlexibleForm extends RelativeLayout
{
    Context context;
    RelativeLayout.LayoutParams relativeParams;
    RelativeLayout.LayoutParams buttonParams;
    List<TextView> textViewList;
    List<LayoutParams> layoutTextViewList;
    List<LayoutParams> layoutEditTextList;
    List<LayoutParams> layoutFeedbackList;
    private int lastTextViewTopMargin;
    private int lastEditTextTopMargin;

    List<AccountParameter> params;
    private final static int MARGIN_TOP_BETWEEN_TEXTVIEW = 250;
    private final static int MARGIN_TOP_BETWEEN_EDITTEXT = 250;
    private final static int LEFT_MARGIN_EDITTEXT = 200;
    private final static String USER_ACCOUNT = "UserAccount";
    private final static String ADMIN_ACCOUNT = "AdminAccount";
    Button button;

    List<InteractiveField> interactiveFields;

    InputFeedback inputFeedback;
    AccountRegistration accountRegistration;
    // No input feedback, no account registration.
    public FlexibleForm(Context theContext, List<AccountParameter> theAccountParameters,
                           boolean useInputFeedbackPattern, boolean useAccountRegistrationPattern)
    {
        super(theContext);
        context = theContext;
        params = new ArrayList<AccountParameter>();
        params = theAccountParameters;
        if (useInputFeedbackPattern)
            setInputFeedbackPattern();

        if (useAccountRegistrationPattern)
            setAccountRegistrationPattern();

        init();

    }
    public void setInputFeedbackPattern()
    {
        inputFeedback = new InputFeedback(context, params);
    }
    private void setAccountRegistrationPattern()
    {
        accountRegistration = new AccountRegistration(context, params, inputFeedback, USER_ACCOUNT);

    }
    private void init()
    {

        textViewList = new ArrayList<TextView>();
        layoutTextViewList = new ArrayList<LayoutParams>();
        layoutEditTextList = new ArrayList<LayoutParams>();
        interactiveFields = new ArrayList<InteractiveField>();

        for (int i = 0; i < params.size(); i++)
        {
            textViewList.add(new TextView(context));
            textViewList.get(i).setText(params.get(i).getName());

            interactiveFields.add(new InteractiveField(context, params.get(i)));

            if (params.get(i).getName().equals("Password"))
            {
                interactiveFields.get(i).setTransformationMethod(new PasswordTransformationMethod());
            }
        }
        button = new Button(context);
        button.setText("Register");

        // Display toast
        /** Check if the fields are correct **/
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> badFields = new ArrayList<String>();
                for (int i = 0; i < interactiveFields.size(); i++)
                {
                    if (!interactiveFields.get(i).getAccountParameter().getStatus()) {
                        badFields.add(interactiveFields.get(i).getAccountParameter().getName());
                    }
                }
                if (accountRegistration != null)
                    accountRegistration.tryCreateAccount(badFields);
            }
        });
        initLayout();
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
            interactiveFields.get(i).setLayoutParams(layoutEditTextList.get(i));

            lastEditTextTopMargin = lastEditTextTopMargin + MARGIN_TOP_BETWEEN_EDITTEXT;
            if (interactiveFields.get(i).getAccountParameter().hasAlgorithm())
            {
                interactiveFields.get(i).getAccountParameter().getVisualizationMethod().
                        setPosition(lastEditTextTopMargin - 90);
            }
            addView(textViewList.get(i));
            addView(interactiveFields.get(i));

            if (interactiveFields.get(i).getAccountParameter().hasAlgorithm())
            {
                addView(interactiveFields.get(i).getAccountParameter().getVisualizationMethod().getView());
            }

        }

        buttonParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);

        buttonParams.topMargin = lastEditTextTopMargin + 20;
        buttonParams.rightMargin = 400;
        buttonParams.leftMargin = 400;

        addView(button, buttonParams);
    }


}
