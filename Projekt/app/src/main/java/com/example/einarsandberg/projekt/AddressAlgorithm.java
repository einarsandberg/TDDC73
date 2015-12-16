package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-14.
 */

/*
    Checks if there is a street number included in the string
 */
public class AddressAlgorithm implements FieldAlgorithmInterface
{
    public AddressAlgorithm()
    {

    }
    @Override
    public boolean checkField(String address)
    {
        for (int i = 0; i < address.length(); i++)
        {
            if (Character.isDigit(address.charAt(i)))
            {
                return true;
            }
        }
        return false;
    }
    public String getStrengthLevel(String address)
    {
        return "";
    }
    public int getProgress(String address)
    {
        return 0;
    }
}
