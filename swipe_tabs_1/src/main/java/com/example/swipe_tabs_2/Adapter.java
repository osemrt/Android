package com.example.swipe_tabs_2;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

class Adapter extends FragmentStatePagerAdapter {
    private final int numOfTabs;

    public Adapter(FragmentManager supportFragmentManager, int numOfTabs) {
        super(supportFragmentManager);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentA();
            case 1:
                return new FragmentB();
            case 2:
                return new FragmentC();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
