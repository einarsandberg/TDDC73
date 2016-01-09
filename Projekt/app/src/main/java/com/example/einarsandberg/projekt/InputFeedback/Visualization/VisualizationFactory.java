package com.example.einarsandberg.projekt.InputFeedback.Visualization;
import android.content.Context;

/**
 * Created by einarsandberg on 2015-12-16.
 */

/**
 * Create the correct visualization, given the visualization type.
 */
public class VisualizationFactory
{
    public VisualizationMethod getVisualizationMethod(Context theContext, String visualizationType)
    {
        if (visualizationType.equals("ProgressBar"))
            return new PasswordStrengthBar(theContext, null, android.R.attr.progressBarStyleHorizontal);


        else if (visualizationType.equals("TextFeedback"))
        {
            return new TextFeedback(theContext);
        }
        return null;
    }

}
