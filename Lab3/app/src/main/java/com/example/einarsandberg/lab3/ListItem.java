package com.example.einarsandberg.lab3;
import android.view.*;
import android.graphics.*;
import android.content.Context;
/**
 * Created by einarsandberg on 2015-11-26.
 */
public class ListItem extends View
{
    private String item;
    Paint paint;
    public ListItem(Context context, String theItem)
    {
        super(context);
        item = theItem;
        init();
    }

    public void init()
    {
        paint = new Paint();
        paint.setTextSize(50);
        paint.setColor(Color.BLUE);
        if (item == "No results found")
            paint.setColor(Color.RED);

        paint.setStyle(Paint.Style.FILL);
    }
    @Override
    protected void onDraw(Canvas canvas)
    {
        canvas.drawText(item, 10, 50, paint);

    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        this.setMeasuredDimension(600, 100); //would like to match width to length of text, not sure how to do that
    }
}
