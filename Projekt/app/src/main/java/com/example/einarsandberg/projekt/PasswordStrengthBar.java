package com.example.einarsandberg.projekt;
import android.content.Context
import android.widget.ProgressBar;
import android.util.*;
/**
 * Created by einarsandberg on 2015-12-02.
 */
public class PasswordStrengthBar extends ProgressBar
{
    Context context;
    public PasswordStrengthBar(Context theContext, AttributeSet attrs, int defStyle)
    {
        super(theContext, attrs, defStyle);
        context = theContext;
    }

}
