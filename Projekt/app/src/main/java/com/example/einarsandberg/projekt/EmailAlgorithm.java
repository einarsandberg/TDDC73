package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-11.
 */
/* Simple algorithm to check if email format is correct.

    Checks for "@" and if it ends with .SOMETHING (at least two chars)
 */
public class EmailAlgorithm implements EmailAlgorithmInterface
{

    public EmailAlgorithm()
    {

    }

    public boolean checkEmail(String email)
    {
        boolean containsAtChar = false;
        boolean validEmail = false;
        String afterAtChar = "";
        String stringEnd;
        String abc = "abcdefghijklmnopqrstuvxyz";
        for (int i = 0; i < email.length(); i++)
        {
            if (email.charAt(i) == '@')
            {
                containsAtChar = true;
                afterAtChar = email.substring(i+1);
                break;
            }
        }
        if (containsAtChar)
        {
            for (int i = 0; i < abc.length(); i++)
            {
                if (afterAtChar.endsWith("." + abc.charAt(i)))
                {
                    stringEnd = afterAtChar.substring(afterAtChar.lastIndexOf(".") + 1);
                    if (stringEnd.length() > 1)
                    {
                        validEmail = true;
                        break;
                    }
                }
            }
        }
        return validEmail;
    }
}
