package com.example.einarsandberg.projekt;
import android.content.Context;
import android.widget.ProgressBar;
import android.util.*;
import android.graphics.*;
import android.util.Log;
import android.widget.EditText;
import android.view.View;
import android.widget.RelativeLayout;

/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthBar extends ProgressBar implements VisualizationMethod
{
    private static final String TAG = "PasswordStrengthBar";
    Context context;
    private String text;
    Paint paint;
    private int progress;
    RelativeLayout.LayoutParams layoutParams;
    boolean state;
    public PasswordStrengthBar(Context theContext, AttributeSet attrs, int defStyle)
    {
        super(theContext, attrs, defStyle);
        context = theContext;
        init();
    }
    public void init()
    {
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        text = "Too short";
        state = false;
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        setProgress(progress);
        canvas.drawText(text, 100, 100, paint);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), 100);
        Log.d("HEJ: ", String.valueOf(MeasureSpec.getSize(widthMeasureSpec)));
    }

    public void setFeedback(String theText, int theProgress)
    {
        invalidate();
        text = theText;
        progress = theProgress;
        // should be valid for all algorithm states except if password too short
        if (progress > 20)
        {
            state = true;
        }
        else
            state = false;
    }
    public View getView()
    {
        return this;
    }
    //should not be implemented
    public void setFeedback(boolean theState)
    {

    }
    public void setPosition(int topMargin)
    {
        layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.topMargin = topMargin;
        this.setLayoutParams(layoutParams);
    }
    public boolean getFeedback()
    {
        return state;
    }

}
