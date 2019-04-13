package com.example.storing_data;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private EditText editText;
    private Button saveButton;
    private Button getButton;
    private SharedPreferences sharedPreferences;

    private static final String PREFS_NAME = "myPrefsFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();


    }

    private void setUpUI() {
        sharedPreferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);

        textView = (TextView) findViewById(R.id.textView);
        editText = (EditText) findViewById(R.id.editText);
        saveButton = (Button) findViewById(R.id.saveButton);
        getButton = (Button) findViewById(R.id.getButton);

        saveButton.setOnClickListener(this);
        getButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.saveButton:
                save(editText.getText().toString(), "message");
                break;
            case R.id.getButton:
                textView.setText(get("message"));
                break;

        }
    }

    private String get(String key) {
        return sharedPreferences.getString(key, "not found!");
    }

    private void save(String string, String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, string);
        editor.commit();
    }
}
