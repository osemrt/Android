package com.example.input_method_framework;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main extends Activity implements TextView.OnEditorActionListener {

    private TextView editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = (TextView) findViewById(R.id.editText);
        this.editText.setOnEditorActionListener(this);

    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId== EditorInfo.IME_ACTION_DONE){
            Toast.makeText(this, "You clicked the DONE button", Toast.LENGTH_LONG).show();
            return true;
        }

        return false;
    }
}
