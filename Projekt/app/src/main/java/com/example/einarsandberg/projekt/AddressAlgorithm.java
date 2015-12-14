package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-14.
 */

/*
    Checks if there is a street number included in the string
 */
public class AddressAlgorithm implements AddressAlgorithmInterface
{
    public AddressAlgorithm()
    {

    }

    public boolean checkAddress(String address)
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
}
