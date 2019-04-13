package com.example.recycle_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        textView1 = (TextView) findViewById(R.id.description_textView1);
        textView2 = (TextView) findViewById(R.id.description_textView2);

        Intent intent = getIntent();
        textView1.setText(intent.getExtras().getString("Title"));
        textView2.setText(intent.getExtras().getString("Description"));
    }
}
