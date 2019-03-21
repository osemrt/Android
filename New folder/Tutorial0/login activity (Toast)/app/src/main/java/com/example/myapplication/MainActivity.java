package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    RadioButton radioButton1;
    RadioButton radioButton2;
    Button button;
    RadioGroup radioGroup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               String name = editText1.getText().toString();
               String email = editText2.getText().toString();
               String password = editText3.getText().toString();
               String salute;

               System.out.println(name + email + password);

               Toast.makeText(MainActivity.this,"Clicked", Toast.LENGTH_SHORT).show();

                if(radioButton1.isChecked()){
                    salute = "Mrs.";
                }else if(radioButton2.isChecked()){
                    salute = "Mr.";
                }else{
                    salute = "?.";
                }


                int i = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(i);

               Toast.makeText(MainActivity.this, salute + name + email + password, Toast.LENGTH_LONG).show();
               Toast.makeText(MainActivity.this, "Gender : " + radioButton.getText() + name + email + password, Toast.LENGTH_LONG).show();




            }
        });


    }











}
