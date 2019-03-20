package com.example.alert_dialog_customization;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class Main extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showDialog1(View view){
        MyDialog myDialog = new MyDialog();
        myDialog.show(getFragmentManager(), "MyDialog");
    }


    public void showDialog2(View view){
        MyDialog2 myDialog = new MyDialog2();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayout, myDialog, "showDialog2");
        fragmentTransaction.commit();
    }

}
