package com.example.fragment_part2;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.util.Log;

/**
 * Communication between two fragments
 *
 *
 */

public class MainActivity extends Activity implements Communicator {

    private FragmentManager fragmentManager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getFragmentManager();
        firstFragment = (FirstFragment) fragmentManager.findFragmentById(R.id.fragment1);
        secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment2);
    }

    @Override
    public void respond(String string) {
        String[] tokens;
        tokens = string.split(" ", 2);
        if(!tokens[1].equalsIgnoreCase("")){
            if("FirstFragment".equalsIgnoreCase(tokens[0])){
                secondFragment.setTextView(tokens[1]);
            }else if("SecondFragment".equalsIgnoreCase(tokens[0])){
                firstFragment.setTextView(tokens[1]);
            }

        }


    }
}
