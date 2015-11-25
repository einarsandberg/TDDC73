package com.example.einarsandberg.lab3;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import android.os.Bundle;
import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.EditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.graphics.Color;
import android.util.Log;
import java.net.URLConnection;
import android.text.TextWatcher;
import android.content.Context;
import android.util.*;
import java.io.BufferedReader;

/**
 * Created by einarsandberg on 2015-11-25.
 */
public class InteractiveSearcher extends EditText
{
    private static final String TAG = "InteractiveSearcher"; // for logging
    Context context;
    private int searchID;
    HttpURLConnection urlConnection;
    public InteractiveSearcher(Context theContext)
    {
        super(theContext);
        context = theContext;
        searchID = 0;
        init();
    }
    public InteractiveSearcher(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public InteractiveSearcher(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

    }
    private void init()
    {

        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String searchString = s.toString();
                initConnection(searchString);
                try
                {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                    String returnedText = readStream(in);
                    Log.d(TAG, returnedText);
                }
                catch (Exception e)
                {
                    Log.d(TAG, "Error reading from stream");
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void initConnection(String theSearchString)
    {

        try
        {
            URL url = new URL("http://flask-afteach.rhcloud.com/getnames/" + searchID + "/" + theSearchString);
            searchID++;
            Log.d(TAG, url.toString());
            urlConnection = (HttpURLConnection) url.openConnection();

        }
        catch(Exception e)
        {
            Log.d(TAG, "Error initializing connection");
            e.printStackTrace();
        }

    }
    private String readStream(InputStream in)
    {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in), 1000);
        try
        {
            for (String line = bufferedReader.readLine(); line != null; line =bufferedReader.readLine())
            {
                sb.append(line);
            }
            in.close();

        }
        catch(Exception e)
        {
            Log.d(TAG, "Error reading stream");
            e.printStackTrace();
        }
        return sb.toString();
    }


}
