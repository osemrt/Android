package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView3;
    EditText editText1;
    EditText editText2;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView3 = findViewById(R.id.textView3);
        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);

    }


    public void add(View view){
        int num1 = Integer.parseInt(editText1.getText().toString());
        int num2 = Integer.parseInt(editText2.getText().toString());

        textView3.setText("Answer is " + (num1+num2));
    }

}
