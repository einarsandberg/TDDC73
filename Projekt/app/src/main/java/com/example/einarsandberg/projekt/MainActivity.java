package com.example.einarsandberg.projekt;
import android.widget.LinearLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{
    LinearLayout linearLayout;
    PasswordStrengthMeter passwordStrengthMeter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        linearLayout = new LinearLayout(this);
        passwordStrengthMeter = new PasswordStrengthMeter(this);
        linearLayout.addView(passwordStrengthMeter);
        setContentView(linearLayout);

    }
}
