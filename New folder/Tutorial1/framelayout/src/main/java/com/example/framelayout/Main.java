package com.example.framelayout;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import androidx.annotation.Nullable;

public class Main extends Activity implements OnClickListener {


    private ImageView imageView1;
    private ImageView imageView2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);

        imageView1.setOnClickListener(this);
        imageView2.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if(v.getId()==imageView1.getId()){
            imageView1.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
        }else if(v.getId()==R.id.imageView2){
            imageView1.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
        }


    }
}
