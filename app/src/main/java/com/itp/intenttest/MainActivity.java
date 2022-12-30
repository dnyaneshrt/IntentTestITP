package com.itp.intenttest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_welcome,btn_dial,btn_linkedin,btn_steam,btn_paytm;
    EditText editText,et_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_welcome= findViewById(R.id.btn_welcome);
        editText=findViewById(R.id.et_name);
        btn_dial=findViewById(R.id.btn_dial);
        btn_linkedin=findViewById(R.id.btn_linkedin);
        btn_steam=findViewById(R.id.btn_steamhub);
        btn_paytm=findViewById(R.id.btn_paytm);
        et_number=findViewById(R.id.et_number);


        btn_welcome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              Intent intent=new Intent(MainActivity.this,WelcomeActivity.class);
              intent.putExtra("name",editText.getText().toString());
              startActivity(intent);
//             startActivity(new Intent(MainActivity.this,WelcomeActivity.class));
            }
        });

        //implicit intent is used to call built in activities
        btn_dial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+et_number.getText().toString()));
                startActivity(intent);
            }
        });

        btn_linkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                Intent intent= getPackageManager().getLaunchIntentForPackage("com.linkedin.android");
                if(intent!=null) {
                    startActivity(intent);
                }else
                {
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.linkedin.android"));
                    startActivity(intent1);
                }
            }
        });

        btn_paytm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if(intent!=null) {
                    startActivity(intent);
                }else
                {
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=net.one97.paytm"));
                    startActivity(intent1);
                }
            }
        });
        btn_steam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= getPackageManager().getLaunchIntentForPackage("com.forbesmarshall.fm.lxn");
                if(intent!=null) {
                    startActivity(intent);
                }else
                {
                    Intent intent1=new Intent();
                    intent1.setAction(Intent.ACTION_VIEW);
                    intent1.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.forbesmarshall.fm.lxn"));
                    startActivity(intent1);
                }

            }
        });

    }
}