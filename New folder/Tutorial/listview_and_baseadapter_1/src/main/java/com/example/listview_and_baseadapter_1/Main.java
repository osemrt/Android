package com.example.listview_and_baseadapter_1;

/*
    The benefit of the base adapter enables us to control all things over the list view.

 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends Activity {

    private ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.listView = (ListView) findViewById(R.id.listView);

        Adapter adapter = new Adapter(this);

        listView.setAdapter(adapter);

    }
}
