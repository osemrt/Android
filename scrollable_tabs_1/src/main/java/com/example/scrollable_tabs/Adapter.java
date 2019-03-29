package com.example.scrollable_tabs;

import android.util.Log;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class Adapter extends FragmentPagerAdapter {
    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("OSE", "getItem(" + Integer.toString(position) + ") is called!");
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = new FragmentA();
                break;
            case 1:
                fragment = new FragmentB();
                break;
            case 2:
                fragment = new FragmentC();
                break;
            default:
                fragment = null;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        Log.e("OSE", "getCount() is called!");
        return 3;
    }
}
