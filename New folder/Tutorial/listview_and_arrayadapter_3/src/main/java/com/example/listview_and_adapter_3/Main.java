package com.example.listview_and_adapter_3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class Main extends Activity {

    private ListView listView;
    private String[] titles;
    private String[] descriptions;
    private int[] images = {R.drawable.image1,  R.drawable.image2,  R.drawable.image3,  R.drawable.image4,
                            R.drawable.image5,  R.drawable.image6,  R.drawable.image7,  R.drawable.image8,
                            R.drawable.image9,  R.drawable.image10, R.drawable.image11, R.drawable.image12,
                            R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16,
                            R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20,
                            R.drawable.image1,  R.drawable.image2,  R.drawable.image3,  R.drawable.image4,
                            R.drawable.image5,  R.drawable.image6,  R.drawable.image7,  R.drawable.image8,
                            R.drawable.image9,  R.drawable.image10, R.drawable.image11, R.drawable.image12,
                            R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16,
                            R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20,
                            R.drawable.image1,  R.drawable.image2,  R.drawable.image3,  R.drawable.image4,
                            R.drawable.image5,  R.drawable.image6,  R.drawable.image7,  R.drawable.image8,
                            R.drawable.image9,  R.drawable.image10, R.drawable.image11, R.drawable.image12,
                            R.drawable.image13, R.drawable.image14, R.drawable.image15, R.drawable.image16,
                            R.drawable.image17, R.drawable.image18, R.drawable.image19, R.drawable.image20};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titles = getResources().getStringArray(R.array.titles);
        descriptions = getResources().getStringArray(R.array.descriptions);

        this.listView = (ListView) findViewById(R.id.listView);
        Adapter adapter = new Adapter(this, R.layout.template_row, titles, descriptions, images);
        listView.setAdapter(adapter);

    }
}
