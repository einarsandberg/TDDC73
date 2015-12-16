package com.example.einarsandberg.projekt;
import android.content.Context;
/**
 * Created by einarsandberg on 2015-12-16.
 */
public class VisualizationFactory
{
    public VisualizationMethod getVisualizationMethod(Context theContext, String visualizationType)
    {
        if (visualizationType.equals("ProgressBar"))
            return new PasswordStrengthBar(theContext, null, android.R.attr.progressBarStyleHorizontal);

        else if (visualizationType.equals("FieldColorFeedback"))
        {
            return new FieldColorFeedback(theContext);
        }
        return null;
    }

}
