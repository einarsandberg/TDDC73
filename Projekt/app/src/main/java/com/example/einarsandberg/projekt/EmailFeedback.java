package com.example.einarsandberg.projekt;

import android.widget.RelativeLayout;
import android.content.Context;

/**
 * Created by einarsandberg on 2015-12-11.
 */
public class EmailFeedback
{
    private EmailAlgorithmInterface emailAlgorithm;
    Context context;
    public EmailFeedback(Context theContext)
    {
        emailAlgorithm = new EmailAlgorithm();
        context = theContext;
    }
    private boolean isEmailValid(String email)
    {
        if (emailAlgorithm.checkEmail(email))
            return true;

        return false;
    }
}
