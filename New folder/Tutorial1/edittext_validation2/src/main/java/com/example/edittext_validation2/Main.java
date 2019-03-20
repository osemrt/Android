package com.example.edittext_validation2;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main extends Activity implements TextWatcher {


    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.editText = findViewById(R.id.editText);
        this.editText.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Toast.makeText(this, "beforeTextChanged", Toast.LENGTH_SHORT).show();
        Log.e("OSE", "beforeTextChanged");

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Toast.makeText(this, "onTextChanged", Toast.LENGTH_LONG).show();
        Log.e("OSE", "onTextChanged");
    }

    @Override
    public void afterTextChanged(Editable s) {
        Toast.makeText(this, "afterTextChanged", Toast.LENGTH_SHORT).show();
        Log.e("OSE", "afterTextChanged");

        try{
            if (Integer.parseInt(s.toString()) > 100) {
                s.replace(0, s.length(), "100");
            }
        }catch (Exception e){
            Log.e("OSE", "to handle the exception that occurs when I want to delete all strings from an empty editText");
        }


    }
}
