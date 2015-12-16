package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-15.
 */
public interface FieldAlgorithmInterface
{
    boolean checkField(String fieldText);

    String getStrengthLevel(String fieldText);

    int getProgress(String fieldText);

}
