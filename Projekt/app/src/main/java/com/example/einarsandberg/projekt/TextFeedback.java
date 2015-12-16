package com.example.einarsandberg.projekt;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by einarsandberg on 2015-12-16.
 */
public class TextFeedback extends TextView implements VisualizationMethod
{
    Context context;
    String text;
    private static final String VALID = "Valid";
    private static final String UNVALID = "Unvalid";
    RelativeLayout.LayoutParams layoutParams;
    public TextFeedback(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
    }
    public View getView()
    {
        return this;
    }
    public void init()
    {
        setTextSize(10);
        setBackgroundColor(Color.parseColor("#ff6666"));
        text = UNVALID;
    }
    public void setFeedback(boolean state)
    {
        //invalidate();
        if (state)
        {
            setBackgroundColor(Color.parseColor("#99cc00"));
            setText(VALID);
        }
        else
        {
            setBackgroundColor(Color.parseColor("#ff6666"));
            setText(UNVALID);
        }

    }
    // should not be implemented
    public void setFeedback(String text, int progress)
    {

    }
    public void setPosition(int topMargin)
    {

        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = topMargin;
        this.setLayoutParams(layoutParams);
    }


}
