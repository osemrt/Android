package com.example.go_back;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        editText = (EditText) findViewById(R.id.editText2);


    }


    public void goBack(View view) {

        Intent intent = getIntent();
        intent.putExtra("Message", editText.getText().toString());
        setResult(RESULT_OK);
        finish();

    }

}
