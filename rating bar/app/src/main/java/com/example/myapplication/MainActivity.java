package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar1;
    RatingBar ratingBar2;
    TextView textView1;
    TextView textView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ratingBar1 = findViewById(R.id.ratingBar1);
        ratingBar2 = findViewById(R.id.ratingBar2);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);


        ratingBar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView1.setText(Float.toString(rating));
            }
        });

        ratingBar2.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                textView2.setText(Float.toString(rating));
            }
        });



    }
}
