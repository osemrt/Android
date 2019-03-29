package com.example.creating_dialog_with_activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog(View view){

        Intent intent = new Intent(Main.this, Dialog.class);
        startActivity(intent);


    }


}
