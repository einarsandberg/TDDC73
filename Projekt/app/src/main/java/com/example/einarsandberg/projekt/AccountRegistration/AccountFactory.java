package com.example.einarsandberg.projekt.AccountRegistration;

import com.example.einarsandberg.projekt.AccountParameter;
import java.util.List;

/**
 * Created by einarsandberg on 2016-01-08.
 */

/**
 * Create the correct account, given the account type.
 */
public class AccountFactory
{
    public AccountInterface newAccount(String accountType, List<AccountParameter> params)
    {
        if (accountType.equals("AdminAccount"))
            return new AdminAccount(params);

        else if (accountType.equals("UserAccount"))
            return new UserAccount(params);

        return null;
    }
}
