package com.example.words504;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.texttt);

        SqlitClass sqlitClass = new SqlitClass(this);
        List<Wordclass> list=new ArrayList<>();
        list = sqlitClass.getword();
//        ListView listView=findViewById(R.id.list);
//        TextView textView=findViewById(R.id.textveiw);
        Typeface typeface = ResourcesCompat.getFont( this, R.font.angsa);
        textView.setTypeface(typeface);


    }
}
