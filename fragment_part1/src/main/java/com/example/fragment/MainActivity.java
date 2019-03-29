package com.example.fragment;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

/**
 *
 * The ways of creating a fragment
 * statically and dynamically
 *
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FirstFragment firstFragment = new FirstFragment();

        fragmentTransaction.add(R.id.constraintLayout, firstFragment, "TEST");

        fragmentTransaction.commit();

    }

}
