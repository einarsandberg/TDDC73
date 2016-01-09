package com.example.einarsandberg.projekt.InputFeedback.Algorithm;

/**
 * Created by einarsandberg on 2015-12-15.
 */

/**
 * Returns the correct algorithm for the corresponding input parameter
 *
 */
public class AlgorithmFactory
{
    public FieldAlgorithmInterface getAlgorithm(String algorithmType)
    {
        if (algorithmType.equals("Email"))
            return new EmailAlgorithm();

        else if (algorithmType.equals("Address"))
            return new AddressAlgorithm();

        else if (algorithmType.equals("Password"))
            return new PasswordAlgorithm();

        return null;
    }
}
