package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-14.
 */
import android.util.Log;
public class Account
{
    private final static String TAG = "Account";
    private String email;
    private String address;
    private String password;
    public Account(String theEmail, String theAddress, String thePassword)
    {
        email = theEmail;
        address = theAddress;
        password = thePassword;
    }

    public void print()
    {
        Log.d(TAG, email);
        Log.d(TAG, address);
        Log.d(TAG, password);
    }
}
