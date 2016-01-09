package com.example.einarsandberg.projekt.InputFeedback.Algorithm;

/**
 * Created by einarsandberg on 2015-12-15.
 */

/**
 * Interface for the input algorithms.
 *
 */
public interface FieldAlgorithmInterface
{
    boolean checkField(String fieldText);

    String getStrengthLevel(String fieldText);

    int getProgress(String fieldText);

}
