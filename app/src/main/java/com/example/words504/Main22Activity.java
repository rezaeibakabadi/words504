package com.example.words504;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Main22Activity extends AppCompatActivity {
    TextToSpeech textToSpeech;

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        TextView textView1 = findViewById(R.id.meanText);
        TextView textView2 = findViewById(R.id.spellText);
        TextView textView3 = findViewById(R.id.codingText);
        TextView textView4 = findViewById(R.id.synonText);
        textView.setText(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).name);
        textView1.setText(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).mean);
        textView2.setText(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).spell);
        textView3.setText(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).coding);
        textView4.setText(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).synon);

        ImageView imageView = findViewById(R.id.speach);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textToSpeech.speak(ListVeiw_Activity.ssss.get(Main23Activity.mypostion).name, TextToSpeech.QUEUE_FLUSH, null);

            }
        });


//        Typeface typeface = getResources().getFont(R.font.angsa);
//        textView1.setTypeface(typeface);
        Typeface typeface = ResourcesCompat.getFont( this, R.font.angsa);
        textView.setTypeface(typeface);
        Typeface typeface2 = ResourcesCompat.getFont( this, R.font.angsa);
        textView4.setTypeface(typeface2);
    }
}
