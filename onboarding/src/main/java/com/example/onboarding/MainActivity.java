package com.example.onboarding;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] dots;

    private Button backButton;
    private Button nextButton;
    private int currentPage;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        backButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new SliderAdapter(this));
        addDotsIndicator(0);

        viewPager.addOnPageChangeListener(this);

        context = this;
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(currentPage - 1);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentPage==2){
                    startActivity(new Intent(context, AnotherActivity.class));
                    finish();
                }

                viewPager.setCurrentItem(currentPage + 1);
            }
        });


    }

    private void addDotsIndicator(int position) {
        dots = new TextView[3];
        linearLayout.removeAllViews();

        for (int i = 0; i < 3; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));
            linearLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        } else {


        }


    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        addDotsIndicator(i);
        this.currentPage = i;

        if (i == 0) {

            backButton.setEnabled(false);
            nextButton.setEnabled(true);
            backButton.setVisibility(View.INVISIBLE);

            backButton.setText("");
            nextButton.setText("Next");

        } else if (i == dots.length - 1) {

            backButton.setEnabled(true);
            nextButton.setEnabled(true);
            backButton.setVisibility(View.VISIBLE);

            backButton.setText("Back");
            nextButton.setText("Finish");

        } else {

            backButton.setEnabled(true);
            nextButton.setEnabled(true);
            backButton.setVisibility(View.VISIBLE);

            backButton.setText("Back");
            nextButton.setText("Next");

        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
