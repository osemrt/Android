package com.example.tutorial;

import android.app.Activity;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends Activity implements Intentable {


    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void goFirst(View view) {
        intent = new Intent(SecondActivity.this, FirstActivity.class);
        startActivity(intent);
    }

    @Override
    public void goSecond(View view) {
        Toast.makeText(SecondActivity.this, "You are already inside of the Second!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void goThird(View view) {
        intent = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intent);
    }
}
