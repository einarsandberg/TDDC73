package com.example.einarsandberg.projekt;
import android.view.View;
/**
 * Created by einarsandberg on 2015-12-16.
 */
public interface VisualizationMethod
{
    void init();

    View getView();
    void setFeedback(boolean state);
    void setFeedback(String theText, int theProgress);
    boolean getFeedback();
    void setPosition(int topMargin);


}
