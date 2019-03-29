package com.example.bottom_navigation_viw;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Main extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let's set the listener
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);


        //Let's protect the data inside of the fragments
        if (savedInstanceState == null) {
            //Let's show the first fragment that pops up when the application starts
            //getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new HomeFragment()).commit();
            bottomNavigationView.setSelectedItemId(R.id.home_navigation_bottom);
        }

    }

    //Let's enable this function to return true because if it returns a false value, there will not occur anything when you selected an item from the navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.home_navigation_bottom:
                fragment = new HomeFragment();
                break;
            case R.id.favorites_navigation_bottom:
                fragment = new FavoritesFragment();
                break;
            case R.id.search_navigation_bottom:
                fragment = new SearchFragment();
                break;
            default:
                fragment = null;
                break;
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commit();
        //if it returns false, you can still the fragment you want to see, but the navigation button was not be selected!
        return true;

    }
}
