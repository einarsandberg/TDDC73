package com.example.einarsandberg.projekt;
import android.graphics.Color;
import android.view.View;
import android.content.Context;
import android.util.Log;

import android.graphics.drawable.*;
/**
 * Created by einarsandberg on 2015-12-16.
 */
public class FieldColorFeedback implements VisualizationMethod
{
    Context context;
    public FieldColorFeedback(Context theContext)
    {
        context = theContext;

    }
    public int getGoodFeedback()
    {
        return Color.parseColor("#99cc00");

    }
    public int getBadFeedback()
    {
        return Color.parseColor("#ff6666");
    }

    public void init()
    {

    }
    // Should not be implemented
    public void setBar(String text, int progress)
    {

    }
    public View getView()
    {
        return null;
    }


}
