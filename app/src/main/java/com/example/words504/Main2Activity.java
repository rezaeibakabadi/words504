package com.example.words504;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {

    public static int mypostion;
    List<Wordclass> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView listView = findViewById(R.id.list1);
        arrayList=new ArrayList<>();

        ProadapterActivity ss = new ProadapterActivity(ListVeiw_Activity.ssss, this);
        listView.setAdapter(ss);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mypostion = position;
                Intent ss = new Intent(Main2Activity.this, Main22Activity.class);
                startActivity(ss);

            }
        });
    }
}
