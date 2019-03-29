package com.example.alert_dialog;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showDialog1(View view) {
        MyAlertDialog1 myAlertDialog = new MyAlertDialog1();
        myAlertDialog.show(getFragmentManager(), "MyDialog1");

    }

    public void showDialog2(View view) {
        MyAlertDialog2 myAlertDialog = new MyAlertDialog2();
        myAlertDialog.show(getFragmentManager(), "MyDialog2");

    }

    public void showDialog3(View view) {
        MyAlertDialog3 myAlertDialog = new MyAlertDialog3();
        myAlertDialog.show(getFragmentManager(), "MyDialog3");

    }


}
