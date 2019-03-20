package com.example.using_custom_font;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;


import androidx.annotation.Nullable;


public class Main extends Activity {

    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/waltograph.ttf");
        textView.setTypeface(typeface);


    }
}
