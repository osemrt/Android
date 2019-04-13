package com.example.go_back;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int REQUEST_CODE_1 = 1;
    private final static int REQUEST_CODE_2 = 2;

    private TextView textView;
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                startActivityForResult(new Intent(this, FirstActivity.class), REQUEST_CODE_1);
                break;
            case R.id.button2:
                startActivityForResult(new Intent(this, SecondActivity.class), REQUEST_CODE_2);
                break;

        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("OSE", "ssadsad");

        switch (requestCode) {

            case REQUEST_CODE_1:
                Log.e("OSE", "1");
                if (requestCode == RESULT_OK)
                    Log.e("OSE", data.getStringExtra("Message"));
                    textView.setText("From First Activity: " + data.getStringExtra("Message"));
                break;

            case REQUEST_CODE_2:
                Log.e("OSE", "2");
                if (requestCode == RESULT_OK)
                    Log.e("OSE", data.getStringExtra("Message"));
                    textView.setText("From Second Activity: " + data.getStringExtra("Message"));
                break;
        }

    }
}
