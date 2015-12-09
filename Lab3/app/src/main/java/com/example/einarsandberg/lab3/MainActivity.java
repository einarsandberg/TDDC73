package com.example.einarsandberg.lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.util.Log;
public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity"; // for logging
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        InteractiveSearcher searcher = new InteractiveSearcher(this);
        searcher.setNumOfResults(10);
        linearLayout.addView(searcher);

        setContentView(linearLayout);
    }
}
