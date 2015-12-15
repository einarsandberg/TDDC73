package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-15.
 */
public class AccountParameter
{
    private String text;
    private int positionX;
    private int positionY;
    public AccountParameter(String theText)
    {
        text = theText;
    }
    public String getName()
    {
        return text;
    }

}
