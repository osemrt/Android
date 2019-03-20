package com.example.scrollable_tabs;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

/*
    FragmentStatePagerAdapter vs FragmentPagerAdapter

 */

public class Main extends FragmentActivity {

    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        this.viewPager.setAdapter(new Adapter(getSupportFragmentManager()));
    }
}
