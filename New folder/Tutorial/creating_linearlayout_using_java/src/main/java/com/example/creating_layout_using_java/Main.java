package com.example.creating_layout_using_java;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;

/*
    Context is the superclass of the activity, and Activity is the super class of Main
    so, context is the superclass of the Main class.


 */


public class Main extends Activity {


    private LinearLayout linearLayout;
    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        linearLayout = new LinearLayout(this);
        button = new Button(this);
        textView = new TextView(this);

        LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        linearLayout.setLayoutParams(layoutParams1);
        button.setLayoutParams(layoutParams2);
        button.setLayoutParams(layoutParams2);

        linearLayout.setOrientation(LinearLayout.VERTICAL);
        button.setText("Button Here!");
        textView.setText("Hello!");

        linearLayout.addView(button);
        linearLayout.addView(textView);

        setContentView(linearLayout);


    }
}
