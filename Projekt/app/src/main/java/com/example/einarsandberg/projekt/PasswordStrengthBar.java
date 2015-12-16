package com.example.einarsandberg.projekt;
import android.content.Context;
import android.widget.ProgressBar;
import android.util.*;
import android.graphics.*;
import android.util.Log;
import android.widget.EditText;
import android.view.View;
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
    public PasswordStrengthBar(Context theContext, AttributeSet attrs, int defStyle)
    {
        super(theContext, attrs, defStyle);
        context = theContext;
        text = "Too short";
        init();
    }
    public void init()
    {
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
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

    public void setBar(String theText, int theProgress)
    {
        invalidate();
        text = theText;
        progress = theProgress;
    }
    // Should not be implemented
    public int getGoodFeedback()
    {
        return 0;
    }
    // Should not be implemented
    public int getBadFeedback()
    {
        return 0;
    }
    public View getView()
    {
        return this;
    }

}
