package com.example.creating_relativelayout_using_java;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Main extends Activity {

    private RelativeLayout relativeLayout;
    private EditText editText1, editText2;
    private TextView textView1, textView2, textView3;
    private Button button;
    private LayoutParams layoutParams;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setDimensionsOfRelativeLayout();
        setTextView1();
        addViewsToRelativeLayout();
        setContentView(relativeLayout);
    }

    private void addViewsToRelativeLayout() {
        relativeLayout.addView(textView1, layoutParams);
    }

    private void setTextView1() {
        layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        textView1.setText("Please Log In!");
        textView1.setLayoutParams(layoutParams);
    }

    private void setDimensionsOfRelativeLayout() {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
        relativeLayout.setLayoutParams(layoutParams);
    }


    private void initialize(){
        relativeLayout = new RelativeLayout(this);
        editText1 = new EditText(this);
        editText2 = new EditText(this);
        textView1 = new TextView(this);
        textView2 = new TextView(this);
        textView3 = new TextView(this);
        button = new Button(this);

    }

}
