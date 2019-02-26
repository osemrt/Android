package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    RadioGroup radioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);

        radioGroup = findViewById(R.id.radioGroup);

    }

    public void createAccount(View view){

        String name = editText1.getText().toString();
        String email = editText2.getText().toString();
        String password = editText3.getText().toString();

        int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = radioGroup.findViewById(checkedRadioButtonId);
        String gender = radioButton.getText().toString();

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);

        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("password", password);
        intent.putExtra("gender", gender);

        startActivity(intent);


    }




}
