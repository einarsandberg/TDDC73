package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-07.
 */
public interface PasswordAlgorithmInterface
{
    String getStrengthLevel(String password);

    int getProgress(String strengthLevel);
}
