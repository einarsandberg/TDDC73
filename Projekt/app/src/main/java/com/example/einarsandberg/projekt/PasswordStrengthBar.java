package com.example.einarsandberg.projekt;
import android.content.Context;
import android.widget.ProgressBar;
import android.util.*;
import android.graphics.*;
import android.widget.*;
import android.util.Log;
/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthBar extends ProgressBar
{
    Context context;
    private String text;
    Paint paint;
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


    }
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        canvas.drawText(text, 100, 100, paint);

    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(MeasureSpec.getSize(widthMeasureSpec), 100);
        Log.d("HEJ: ", String.valueOf(MeasureSpec.getSize(widthMeasureSpec)));
    }

    private void setText(String theText)
    {
        text = theText;
    }

}
