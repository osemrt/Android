package com.example.checkbox_eventlistener;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main extends Activity implements View.OnClickListener {

    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        checkBox1.setOnClickListener(this);
        checkBox2.setOnClickListener(this);
        checkBox3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        int selectedId = v.getId();

        switch (selectedId){
            case R.id.checkBox1:
                Toast.makeText(this, "You have selected checkBox1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox2:
                Toast.makeText(this, "You have selected checkBox2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkBox3:
                Toast.makeText(this, "You  haveselected checkBox3", Toast.LENGTH_SHORT).show();
                break;
        }


    }
}
