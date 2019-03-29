package com.example.swipe_tabs_2;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

public class Main extends FragmentActivity implements TabLayout.BaseOnTabSelectedListener {

    private ViewPager viewPager;
    private Toolbar toolBar;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ToolBar
        this.toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle("TabLayout");
        //setSupportActionBar(toolBar);

        //TabLayout
        this.tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(this);


        //ViewPager
        this.viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(new Adapter(getSupportFragmentManager(), tabLayout.getTabCount()));
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }

    //TabLayout Listener
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        switch (tab.getPosition()){
            case 1:
                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.design_default_color_primary));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorAccent));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.darker_gray));
                break;
            case 2:
                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.darker_gray));
                break;
            case 3:
                toolBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                tabLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                    getWindow().setStatusBarColor(ContextCompat.getColor(this, android.R.color.darker_gray));
                break;


        }

    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
