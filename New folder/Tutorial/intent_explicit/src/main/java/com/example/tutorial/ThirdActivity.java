package com.example.tutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ThirdActivity extends Activity implements Intentable {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
    }

    @Override
    public void goFirst(View view) {
        intent = new Intent(ThirdActivity.this, FirstActivity.class);
        startActivity(intent);
    }

    @Override
    public void goSecond(View view) {
        intent = new Intent(ThirdActivity.this, SecondActivity.class);
        startActivity(intent);
    }

    @Override
    public void goThird(View view) {
        Toast.makeText(ThirdActivity.this, "You are already inside of the THIRD!", Toast.LENGTH_SHORT).show();
    }
}
