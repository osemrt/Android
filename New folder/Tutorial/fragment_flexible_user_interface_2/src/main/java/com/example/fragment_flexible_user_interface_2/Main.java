package com.example.fragment_flexible_user_interface_2;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends Activity implements FirstFragment.Communicator {

    private ListView listView;
    private FragmentManager fragmentManager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.titles, android.R.layout.simple_list_item_1);
        this.listView.setAdapter(arrayAdapter);

        this.fragmentManager = getFragmentManager();
        this.firstFragment = (FirstFragment) this.fragmentManager.findFragmentById(R.id.fragment1);
        this.secondFragment = (SecondFragment) this.fragmentManager.findFragmentById(R.id.fragment2);
        this.firstFragment.setCommunicator(this);

    }

    @Override
    public void respond(int position) {


        if (secondFragment != null && secondFragment.isVisible()) {
            secondFragment.changeData(position);
        } else {
            Intent intent = new Intent(this, AnotherActivity.class);
            intent.putExtra("position", position);
            startActivity(intent);

        }


    }

}
