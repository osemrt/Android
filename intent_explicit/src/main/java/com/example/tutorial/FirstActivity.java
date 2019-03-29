package com.example.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FirstActivity extends Activity implements Intentable {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }


    @Override
    public void goFirst(View view) {
        Toast.makeText(FirstActivity.this, "You are already inside of the First!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goSecond(View view) {
        intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void goThird(View view) {
        intent = new Intent(FirstActivity.this, SecondActivity.class);
        startActivity(intent);
    }
}
