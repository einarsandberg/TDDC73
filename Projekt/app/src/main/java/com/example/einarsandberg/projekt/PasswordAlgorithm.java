package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-04.
 */

/* Strength levels is from 1 to 4

A password is 1 if: only lowercase OR uppercase, no numbers, no symbols
              2 if: Lowercase AND uppercase, no numbers, no symbols
              3 if: Lowercase AND uppercase AND numbers OR symbols
              4 if: Lowercase AND uppercase AND numbers AND symbols
 */
public class PasswordAlgorithm
{
    private int strengthLevel;
    private String password;
    public PasswordAlgorithm(String thePassword)
    {
        password = thePassword;
        strengthLevel = 0;

    }

    public int getStrength()
    {
        // Only upper case or lower case?
        if (password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()))
        {
            strengthLevel++;
        }
        else
        {
            strengthLevel++;
            String symbols = "/*!@#$%^&*()\"{}_[]|\\?/<>,.";
            // contains upper case or lower case or symbols or numbers?
            for (int i = 0; i < password.length(); i++)
            {
                // only need to check if lower case due to previous if-statement
                if (Character.isLowerCase(password.charAt(i)))
                {
                    strengthLevel++;
                }
                else if (Character.isDigit(password.charAt(i)))
                {
                    strengthLevel++;
                }
                else
                {
                    // check if symbol
                    for (int k = 0; k < symbols.length(); k++)
                    {
                        if (password.charAt(i) == symbols.charAt(k))
                        {
                            strengthLevel++;
                        }
                    }
                }
            }

        }
        return strengthLevel;
    }
}
