package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-15.
 */
public class AlgorithmFactory
{
    public FieldAlgorithmInterface getAlgorithm(String algorithmType)
    {
        if (algorithmType.equals("Email"))
            return new EmailAlgorithm();

        else if (algorithmType.equals("Address"))
            return new AddressAlgorithm();

        return null;
    }
}
