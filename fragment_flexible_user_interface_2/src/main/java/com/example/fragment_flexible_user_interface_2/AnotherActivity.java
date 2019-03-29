package com.example.fragment_flexible_user_interface_2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class AnotherActivity extends Activity implements FirstFragment.Communicator {

    private ListView listView;
    private FragmentManager fragmentManager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position", 0);

        SecondFragment secondFragment = (SecondFragment) getFragmentManager().findFragmentById(R.id.fragment2);
        if (secondFragment != null)
            secondFragment.changeData(position);

    }

    @Override
    public void respond(int position) {
        if (secondFragment != null && secondFragment.isVisible()) {
            secondFragment.changeData(position);
        }
    }
}
