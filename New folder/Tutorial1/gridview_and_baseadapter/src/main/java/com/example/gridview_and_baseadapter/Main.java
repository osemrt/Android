package com.example.gridview_and_baseadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.Nullable;

public class Main extends Activity implements AdapterView.OnItemClickListener {

    private GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.gridView = (GridView) findViewById(R.id.gridView);

        Adapter adapter = new Adapter(this);
        this.gridView.setAdapter(adapter);
        this.gridView.setOnItemClickListener(this);

    }


    //first parameter: grid view, second one represents the clicked item index
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(this, Dialog.class);
        ViewHolder viewHolder = (ViewHolder) view.getTag();

        //look the important part in the below
        Country country= (Country) viewHolder.getImageView().getTag();
        intent.putExtra("country_name", country.getCountryName());
        intent.putExtra("imageId", country.getImageId());

        startActivity(intent);


    }
}
