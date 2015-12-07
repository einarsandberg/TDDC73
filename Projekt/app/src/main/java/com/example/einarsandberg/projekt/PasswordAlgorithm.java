package com.example.einarsandberg.projekt;
import java.util.*;
/**
 * Created by einarsandberg on 2015-12-04.
 */

/*
Very simple password strength algorithm.

Strength levels is from 0 to 4

A password is 0 if: <7 characters
              1 if: only lowercase OR uppercase, no numbers, no symbols
              2 if: Lowercase AND uppercase, no numbers, no symbols
              3 if: Lowercase AND uppercase AND numbers OR symbols
              4 if: Lowercase AND uppercase AND numbers AND symbols

States determine whether there already is an equal character before,
i.e password will not be stronger just by adding more numbers or characters etc;
 */
public class PasswordAlgorithm implements PasswordAlgorithmInterface
{
    private List<String> strengthLevels;
    boolean caseState;
    boolean numberState;
    boolean symbolState;
    public PasswordAlgorithm()
    {
        strengthLevels = new ArrayList<String>();
        strengthLevels.add("Too short");
        strengthLevels.add("Very weak");
        strengthLevels.add("Weak");
        strengthLevels.add("Strong");
        strengthLevels.add("Very strong");

    }

    public String getStrengthLevel(String password)
    {
        caseState = false;
        numberState = false;
        symbolState = false;
        int strengthLevel = 0;
        if (password.length() < 7)
            return strengthLevels.get(strengthLevel);

        // Only upper case or lower case?
        if (password.equals(password.toLowerCase()) || password.equals(password.toUpperCase()))
        {
            strengthLevel++;
        }
        else
        {
            strengthLevel++;
            String symbols = "/*!@#$%^&*()\"{}_[]|\\?/<>,.=-";
            // contains upper case or lower case or symbols or numbers?
            for (int i = 0; i < password.length(); i++)
            {
                if (strengthLevel == 4) // if max is reached
                    break;
                // only need to check if lower case due to previous if-statement before loop
                // i.e contains both lower and upper case
                if (!caseState && Character.isLowerCase(password.charAt(i)))
                {
                    strengthLevel++;
                    caseState = true;
                }
                else if (!numberState && Character.isDigit(password.charAt(i)))
                {
                    strengthLevel++;
                    numberState = true;
                }
                else
                {
                    // check if symbol
                    for (int k = 0; k < symbols.length(); k++)
                    {
                        if (!symbolState && password.charAt(i) == symbols.charAt(k))
                        {
                            strengthLevel++;
                            symbolState = true;
                        }
                    }
                }

            }

        }
        return strengthLevels.get(strengthLevel);
    }

    public int getProgress(String strengthLevel)
    {
        switch (strengthLevel)
        {
            case "Too short":
                return 20;

            case "Very weak":
                return 40;

            case "Weak":
                return 60;

            case "Strong":
                return 80;

            case "Very strong":
                return 100;

        }
        return 0;
    }
}
