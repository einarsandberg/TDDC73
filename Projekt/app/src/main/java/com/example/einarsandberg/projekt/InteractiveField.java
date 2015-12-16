package com.example.einarsandberg.projekt;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.content.Context;
/**
 * Created by einarsandberg on 2015-12-16.
 */
public class InteractiveField extends EditText
{
    Context context;
    private VisualizationMethod visualizationMethod;
    AccountParameter accountParameter;
    public InteractiveField(Context theContext, AccountParameter theAccountParameter)
    {
        super(theContext);
        context = theContext;
        accountParameter = theAccountParameter;
        init();
    }
    private void init()
    {
        addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (accountParameter.hasAlgorithm())
                {
                    // will do nothing for password
                    accountParameter.getVisualizationMethod().setFeedback(
                                accountParameter.getFieldAlgorithm().checkField(s.toString()));

                    //for password only
                    accountParameter.getVisualizationMethod().setFeedback(
                                accountParameter.getFieldAlgorithm().getStrengthLevel(s.toString()),
                                accountParameter.getFieldAlgorithm().getProgress(
                                        accountParameter.getFieldAlgorithm().getStrengthLevel(s.toString())));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    public AccountParameter getAccountParameter()
    {
        return accountParameter;
    }


}
