package com.example.spinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main extends Activity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1;
    private Spinner spinner2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.spinner1 = (Spinner) findViewById(R.id.spinner1);
        this.spinner2 = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter arrayAdapter1 = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_item);
        ArrayAdapter arrayAdapter2 = ArrayAdapter.createFromResource(this, R.array.days, android.R.layout.simple_spinner_dropdown_item);

        spinner1.setAdapter(arrayAdapter1);
        spinner2.setAdapter(arrayAdapter2);

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, ((TextView) view).getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this, "Nothing selected", Toast.LENGTH_LONG).show();
    }
}
