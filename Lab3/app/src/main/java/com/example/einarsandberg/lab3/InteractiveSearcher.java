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
import org.json.*;
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
import android.widget.ListPopupWindow;
import android.view.ViewGroup;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * Created by einarsandberg on 2015-11-25.
 */
public class InteractiveSearcher extends EditText
{
    private static final String TAG = "InteractiveSearcher"; // for logging
    private HashMap<Integer, ArrayList<String >> searchMap;
    Context context;
    private int searchID;
    HttpURLConnection urlConnection;
    private InputStream in;
    ListPopupWindow popupWindow;
    ItemAdapter itemAdapter;

    public InteractiveSearcher(Context theContext)
    {
        super(theContext);
        context = theContext;
        init();
    }

    private void init()
    {
        searchID = 0;
        searchMap = new HashMap<Integer, ArrayList<String>>();
        this.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        popupWindow = new ListPopupWindow(context);
        popupWindow.setAnchorView(this);

        this.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

                try
                {
                    String searchString = s.toString();
                    new NetworkClass().execute(searchString).get(); // executes doInBackground and onPostExecute

                } catch (Exception e) {
                    Log.d(TAG, "Error reading from stream");
                    e.printStackTrace();
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    // parses JSON and initializes searchMap
    private void parseObject(String retrievedString)
    {
        try
        {
            Log.d(TAG, retrievedString);
            JSONObject jsonObj = new JSONObject(retrievedString);

            JSONArray results = jsonObj.getJSONArray("result");
            ArrayList<String> names = new ArrayList<String>();
            if (results.length() == 0)
            {
                names.add("No results found");
                searchMap.put(searchID, names);
            }
            else
            {
                for (int i = 0; i < results.length(); i++)
                {
                    names.add(results.get(i).toString());
                }
                searchMap.put(searchID, names);
            }
        }
        catch(Exception e)
        {
            Log.d(TAG, "Error parsing JSON");
            e.printStackTrace();
        }

    }

    public class NetworkClass extends AsyncTask<String, Void, String>
    {
        protected String doInBackground(String... theSearchString)
        {
            String returnedText = "";
            try {
                URL url = new URL("http://flask-afteach.rhcloud.com/getnames/" + searchID + "/" + theSearchString[0]);
                searchID++; // new id for each search
                Log.d(TAG, url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                in = new BufferedInputStream(urlConnection.getInputStream());
                returnedText = readStream(in);

                Log.d(TAG, "TJO");


            } catch (Exception e) {
                Log.d(TAG, "Error initializing connection");
                e.printStackTrace();
            }
            finally
            {
                try
                {
                    if (in == null)
                        in.close();

                    if (urlConnection == null)
                        urlConnection.disconnect();

                }
                catch(Exception e)
                {
                    Log.d(TAG, "Error closing input stream or connection");
                    e.printStackTrace();
                }

            }
            return returnedText;
        }

        protected void onPostExecute(String data)
        {
            // parse json data
            parseObject(data);
            Log.d(TAG, "HEJ");

            itemAdapter = new ItemAdapter(context, searchMap.get(searchID));
            popupWindow.setAdapter(itemAdapter);
            popupWindow.show();

        }

        private String readStream(InputStream in) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in), 1000);
            try {

                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine())
                {
                    sb.append(line);
                }
                in.close();

            } catch (Exception e)
            {
                Log.d(TAG, "Error reading stream");
                e.printStackTrace();
            }
            return sb.toString();
        }
    }

}
