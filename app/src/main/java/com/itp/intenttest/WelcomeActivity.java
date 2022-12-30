package com.itp.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        textView=findViewById(R.id.textView);

        String passedName=getIntent().getStringExtra("name");

        textView.setText("welcome: "+passedName);
    }
}