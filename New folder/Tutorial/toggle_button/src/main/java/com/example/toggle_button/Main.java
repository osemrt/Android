package com.example.toggle_button;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

public class Main extends Activity implements CompoundButton.OnCheckedChangeListener {


    private RelativeLayout relativeLayout;
    private ToggleButton toggleButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = findViewById(R.id.relativeLayout);
        toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            relativeLayout.setBackgroundColor(Color.MAGENTA);
        }else{
            relativeLayout.setBackgroundColor(Color.YELLOW);
        }
    }
}
