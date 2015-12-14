package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-14.
 */
public class AddressFeedback
{
    private AddressAlgorithmInterface addressAlgorithm;
    public AddressFeedback()
    {
        addressAlgorithm = new AddressAlgorithm();
    }

    public boolean isAddressValid(String address)
    {
        if (addressAlgorithm.checkAddress(address))
        {
            return true;
        }
        return false;
    }
}
