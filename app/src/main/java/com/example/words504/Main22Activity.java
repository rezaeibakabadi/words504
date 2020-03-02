package com.example.words504;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Main22Activity extends AppCompatActivity {

    TextToSpeech textToSpeech;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main22);


        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("font/afsaneh.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        setContentView(R.layout.activity_main22);
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.US);
                }
            }
        });

        final TextView textView = findViewById(R.id.wordText);
        final TextView textView1 = findViewById(R.id.meanText);
        final TextView textView2 = findViewById(R.id.spellText);
        final TextView textView3 = findViewById(R.id.codingText);
        final TextView textView4 = findViewById(R.id.synonText);
        textView.setText(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).name);
        textView1.setText(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).mean);
        textView2.setText(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).spell);
        textView3.setText(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).coding);
        textView4.setText(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).synon);

        ImageView imageView = findViewById(R.id.speach);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(ListVeiw_Activity.ssss.get(Main2Activity.mypostion).name, TextToSpeech.QUEUE_FLUSH, null);

            }
        });
        final ImageView imageView1 = findViewById(R.id.bookmark);
        final ImageView imageView2 = findViewById(R.id.bookmark2);
        if (ListVeiw_Activity.ssss.get(Main2Activity.mypostion).fav.equals("1")){
            imageView1.setBackgroundResource(R.drawable.bookmark);
            imageView1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean aBoolean;
                    SqlitClass sqlitClass=new SqlitClass(Main22Activity.this);
                    boolean aaaa=   sqlitClass.fav(Main2Activity.mypostion);

                }
            });
        }
        else {
            imageView2.setBackgroundResource(R.drawable.bookmark2);
            imageView2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean aBoolean;
                    SqlitClass sqlitClass=new SqlitClass(Main22Activity.this);
                    boolean aaaa=   sqlitClass.fav(Main2Activity.mypostion);

                }
            });
        }



//        Typeface typeface = getResources().getFont(R.font.angsa);
//        textView1.setTypeface(typeface);
        Typeface typeface = ResourcesCompat.getFont( this, R.font.angsa);
        textView.setTypeface(typeface);
        Typeface typeface2 = ResourcesCompat.getFont( this, R.font.angsa);
        textView4.setTypeface(typeface2);

        SeekBar seekbar = findViewById(R.id.seek);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                textView.setTextSize(i);
                textView1.setTextSize(i);
                textView2.setTextSize(i);
                textView3.setTextSize(i);
                textView4.setTextSize(i);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
