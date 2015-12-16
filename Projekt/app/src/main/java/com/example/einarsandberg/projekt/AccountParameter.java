package com.example.einarsandberg.projekt;

/**
 * Created by einarsandberg on 2015-12-15.
 */
public class AccountParameter
{
    private String text;
    private int positionX;
    private int positionY;
    private FieldAlgorithmInterface fieldAlgorithmInterface;
    private VisualizationMethod visualizationMethod;
    private boolean algorithmState;
    public AccountParameter(String theText)
    {
        text = theText;
    }
    public String getName()
    {
        return text;
    }
    public void setAlgorithm(FieldAlgorithmInterface theFieldAlgorithmInterface)
    {
        fieldAlgorithmInterface = theFieldAlgorithmInterface;
    }
    public FieldAlgorithmInterface getFieldAlgorithm()
    {
        return fieldAlgorithmInterface;
    }
    // Set to true if you want to have an algorithm for the field
    public void setAlgorithmState(boolean theAlgorithmState)
    {
        algorithmState = theAlgorithmState;
    }

    public boolean hasAlgorithm()
    {
        return algorithmState;
    }

    public void setVisualizationMethod(VisualizationMethod theVisualizationMethod)
    {
        visualizationMethod = theVisualizationMethod;
    }
    public VisualizationMethod getVisualizationMethod()
    {
        return visualizationMethod;
    }

}