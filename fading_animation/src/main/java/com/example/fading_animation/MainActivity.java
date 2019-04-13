package com.example.fading_animation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.imageView);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Animation animation= AnimationUtils.loadAnimation(this, R.anim.fadein_animation);
        imageView.startAnimation(animation);
        imageView.setVisibility(View.VISIBLE);
        return super.onTouchEvent(event);
    }
}
