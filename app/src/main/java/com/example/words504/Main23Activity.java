package com.example.words504;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Main23Activity extends AppCompatActivity {
List<Wordclass> arrayList;
public  static int mypostion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);
        ListView listView=findViewById(R.id.list1);
        arrayList=new ArrayList<>();

        Proadapter ss=new Proadapter(ListVeiw_Activity.ssss,this);
        listView.setAdapter(ss);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mypostion=position;
                Intent ss=new Intent(Main23Activity.this,Main22Activity.class);
                startActivity(ss);

            }
        });

    }
}
