package com.example.toast;

/*
    Why do we use the toast?
    -> Give the user feedback regarding some operation
    -> Does not block the Activity or Fragment when it runs
 */

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToasts(View view){

        Toast.makeText(this, "Toast1", Toast.LENGTH_LONG).show();

        Toast toast2 = Toast.makeText(this, "Toast2", Toast.LENGTH_LONG);
        toast2.setGravity(Gravity.LEFT, 0,0 );
        toast2.show();

        Toast toast3 = Toast.makeText(this, "Toast3", Toast.LENGTH_LONG);
        toast3.setGravity(Gravity.CENTER, 0,0 );
        toast3.show();



    }

    public void showCustomToast1(View view){
        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.custom_toast1, null);

        Toast toast = Toast.makeText(this, "Login", Toast.LENGTH_LONG);
        toast.setView(view1);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    public void showCustomToast2(View view){


        LayoutInflater layoutInflater = getLayoutInflater();
        View view1 = layoutInflater.inflate(R.layout.custom_toast2, (ViewGroup) findViewById(R.id.linearLayout1));

        Toast toast = new Toast(this);
        toast.setView(view1);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

}
