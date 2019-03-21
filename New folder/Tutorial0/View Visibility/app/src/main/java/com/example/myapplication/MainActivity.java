package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);


    }

    public void clickedButton1(View view){
        button1.setVisibility(View.INVISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);
    }

    public void clickedButton2(View view){
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.INVISIBLE);
        button3.setVisibility(View.VISIBLE);
    }

    public void clickedButton3(View view){
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.INVISIBLE);
    }



}
