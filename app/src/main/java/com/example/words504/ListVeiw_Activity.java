package com.example.words504;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ListVeiw_Activity extends AppCompatActivity {
    boolean doubleclick = false;
    public static List<Wordclass> ssss = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_veiw_);

        ArrayList<String> Namelist = new ArrayList<>();
        ListView listView = findViewById(R.id.list);
        for (int i = 1; i < 43; i++) {
            String reza = "lesson" + i;
            Namelist.add(reza);
        }
        ArrayAdapter<String> myaddapter = new ArrayAdapter<String>(this, R.layout.activity_main, R.id.texttt, Namelist);
        listView.setAdapter(myaddapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SqlitClass sqlitClass = new SqlitClass(ListVeiw_Activity.this);


                ssss = sqlitClass.lesson(position * 12);
                Intent intent = new Intent(ListVeiw_Activity.this, Main23Activity.class);
                startActivity(intent);


            }
        });

    }
    @Override
    public void onBackPressed() {

        if (doubleclick == true) {
            super.onBackPressed();
        }
        doubleclick = true;
        Toast.makeText(this, "برای خروج دوباره کلیک کنید", Toast.LENGTH_SHORT).show();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleclick = false;
            }
        }, 2500);
    }

}
