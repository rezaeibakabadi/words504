package com.example.words504;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Main24Activity extends AppCompatActivity {
    boolean doubleclick = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        Button button = findViewById(R.id.words);
        Button button1 =findViewById(R.id.source);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main24Activity.this,ListVeiw_Activity.class);
                startActivity(intent);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Main24Activity.this,Main25Activity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public void onBackPressed() {

        if (doubleclick == true) {
            super.onBackPressed();
            finish();
            Toast.makeText(Main24Activity.this, "با تشکر از انتخاب شما", Toast.LENGTH_SHORT).show();
//                    System.exit(0);
        }
        doubleclick = true;
        Toast.makeText(this, "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleclick = false;
            }
        }, 1500);

    }

}
