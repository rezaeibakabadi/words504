package com.example.words504;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SqlitClass sqlitClass = new SqlitClass(this);
        List<Wordclass> list=new ArrayList<>();
        list = sqlitClass.getword();
//        ListView listView=findViewById(R.id.list);
//        TextView textView=findViewById(R.id.textveiw);
    }
}
