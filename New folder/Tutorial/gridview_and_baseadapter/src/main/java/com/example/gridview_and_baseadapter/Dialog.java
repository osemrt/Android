package com.example.gridview_and_baseadapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Dialog extends Activity {


    private ImageView imageView;
    private TextView textView;
    private final int def = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);

        this.imageView = (ImageView) findViewById(R.id.dialog_imageView);
        this.textView = (TextView) findViewById(R.id.dialog_textView);


        Intent intent = getIntent();
        if (intent != null) {
            textView.setText(intent.getStringExtra("country_name"));
            imageView.setImageResource(intent.getIntExtra("imageId", R.drawable.default_flag));
        }

    }

    public void closeDialog(View view) {
        finish();
    }


}
