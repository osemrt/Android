package com.example.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);



    }

    public void clickButton1(View view){
        textView1.setText("Ose");
    }

    public void clickButton2(View view){
        textView2.setText("MRT");

    }

    public void clickButton3(View view){

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure?")
                .setPositiveButton("Ok!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        textView3.setText("$5000");
                    }
                })
                .setNegativeButton("Cancel", null);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setMessage("Are you sure?")
                .setTitle("Really Exit?")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.onBackPressed();
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);


        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
}
