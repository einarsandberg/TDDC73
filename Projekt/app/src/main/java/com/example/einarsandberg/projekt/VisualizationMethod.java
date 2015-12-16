package com.example.einarsandberg.projekt;
import android.view.View;
/**
 * Created by einarsandberg on 2015-12-16.
 */
public interface VisualizationMethod
{
    void init();
    int getGoodFeedback();
    int getBadFeedback();
    void setBar(String text, int progress);
    View getView();


}
