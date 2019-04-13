package com.example.write_and_read;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editText;
    private Button saveButton;
    private Button getButton;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpUI();
        textView.setText(getFromFile("file.txt"));


    }

    private void setUpUI() {
        editText = (EditText) findViewById(R.id.editText);
        saveButton = (Button) findViewById(R.id.saveButton);
        getButton = (Button) findViewById(R.id.getButton);
        textView = (TextView) findViewById(R.id.textView);

        saveButton.setOnClickListener(this);
        getButton.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.saveButton:
                if (!editText.getText().toString().equalsIgnoreCase(""))
                    writeToFile("file.txt", editText.getText().toString());
                break;
            case R.id.getButton:
                editText.setText(getFromFile("file.txt"));
                break;
        }
    }

    private String getFromFile(String fileName) {

        String result="";

        try {

            InputStream inputStream = openFileInput("file.txt");
            if(inputStream!=null){
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String tempString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ((tempString=bufferedReader.readLine())!=null){
                    stringBuilder.append(tempString);
                }

                inputStream.close();
                result = stringBuilder.toString();

            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            return result;
        }
    }

    private void writeToFile(String fileName, String string) {

        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput(fileName, Context.MODE_PRIVATE));
            outputStreamWriter.write(string);
            outputStreamWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
