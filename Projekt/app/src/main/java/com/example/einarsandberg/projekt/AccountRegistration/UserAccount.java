package com.example.einarsandberg.projekt.AccountRegistration;

import com.example.einarsandberg.projekt.AccountParameter;

import java.util.List;

/**
 * Created by einarsandberg on 2016-01-08.
 */
/**
 *  A shell for a user account. Should be extended in order to be useful.
 */
public class UserAccount implements AccountInterface
{
    List<AccountParameter> accountParameters;
    public UserAccount(List<AccountParameter> theAccountParameters)
    {
        accountParameters = theAccountParameters;
    }
    public List<AccountParameter> getAccountParameters()
    {
        return accountParameters;
    }
}
