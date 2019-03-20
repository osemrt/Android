package com.example.orientation;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*
        android:screenOrientation="landscape"
        to keep a defined orientation!

     */



    /*
        <activity
        android:name=".MainActivity"
        android:configChanges="orientation"
        >

        Whenever a configuration occurs with the relating parameters,
        this method is called!

     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e("Test", "The orientation is changed!");

        //it will return orientation as an integer
        Log.e("Test", Integer.toString(newConfig.orientation));

        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            Log.e("Test", "Welcome to the landscape mode!");
        }else if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Log.e("Test", "Welcome to the portrait mode!");
        }else{
            Log.e("Test", "Undefined orientation mode!");
        }

    }
}
