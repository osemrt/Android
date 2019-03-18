package com.example.fragment_flexible_user_interface;



import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;

import androidx.annotation.Nullable;

public class Main extends Activity implements Communicator {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void respond(int position) {
        FragmentManager fragmentManager = getFragmentManager();
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentById(R.id.fragment2);
        secondFragment.changeData(position);

    }
}
