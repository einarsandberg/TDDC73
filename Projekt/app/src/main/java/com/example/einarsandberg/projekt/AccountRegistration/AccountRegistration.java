package com.example.einarsandberg.projekt.AccountRegistration;
import android.content.Context;

import com.example.einarsandberg.projekt.AccountParameter;
import com.example.einarsandberg.projekt.InputFeedback.InputFeedback;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by einarsandberg on 2016-01-08.
 */

/**
 * Create the correct account, given the accountType (user or admin).
 * If any of the input fields is wrong, an account won't be created.
 * Instead, a toast consisting of the wrong input field(s) will be displayed.
 *
 *
 */
public class AccountRegistration
{
    List<AccountParameter> params;
    Context context;
    InputFeedback inputFeedback;
    AccountFactory accountFactory;
    private String accountType;
    public AccountRegistration(Context theContext, List<AccountParameter> theParams,
                               InputFeedback theInputFeedback, String theAccountType)
    {
        context = theContext;
        params = new ArrayList<AccountParameter>();
        params = theParams;
        inputFeedback = theInputFeedback;
        accountType = theAccountType;
        accountFactory = new AccountFactory();
    }


    public void tryCreateAccount(List<String> badFields)
    {
        String text;
        if (badFields.size() > 0)
        {
            text = "Error in ";
            for (int i = 0; i < badFields.size(); i++)
            {
                if (i < badFields.size() - 1)
                {
                    text+= badFields.get(i) + " and ";
                }
                else // if last one, no "and"
                {
                    text += badFields.get(i);
                }
            }
        }
        else
        {
            accountFactory.newAccount(accountType, params);
            text = "Account successfully created";

        }
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }




}
