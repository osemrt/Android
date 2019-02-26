package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    EditText editText1;
    EditText editText2;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);

    }

    public void clickButton(View view1){


        View view2 = LayoutInflater.from(MainActivity.this).inflate(R.layout.activity_main2, null);
        editText1 = view2.findViewById(R.id.editText1);
        editText2 = view2.findViewById(R.id.editText2);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder .setMessage("Login Here")
                .setTitle("Login is required!")
                .setView(view2)
                .setPositiveButton("Login", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = editText1.getText().toString();
                        String password = editText2.getText().toString();

                        if("ose".equalsIgnoreCase(username) && "Abc".equals(password)) {
                            textView.setText("Hi!");
                        }else{
                            Toast.makeText(MainActivity.this, "Login Failed!", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                .setNegativeButton("Cancel", null)
                .setCancelable(false);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }



}
