package com.example.tutorial2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;


public class Main extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Let's throw the drawer to the in front of the Action Bar
        Toolbar toolBar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);

        //Let's add the drawer toggle button
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open_drawer_content_description, R.string.close_drawer_content_description);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //Let's set the listener
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);


        //Let's protect the data inside of the fragments
        if(savedInstanceState==null){
            //Let's show the first fragment that pops up when the application starts
            getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new ChatFragment()).commit();
            navigationView.setCheckedItem(R.id.navigationChat);
        }



    }

    //Let's enable the user to close firstly the drawer when the back button is pressed
    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START);
        } else {
            super.onBackPressed();
        }

    }

    //Let's enable this function to return true because if it returns a false value, there will not occur anything when you selected an item from the navigation view
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch (menuItem.getItemId()) {
            case R.id.navigationChat:
                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new ChatFragment()).commit();
                break;
            case R.id.navigationMessage:
                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new MessageFragment()).commit();
                break;
            case R.id.navigationProfile:
                getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, new ProfileFragment()).commit();
                break;
            case R.id.navigationSend:
                Toast.makeText(this, "'SEND' menu item was selected!", Toast.LENGTH_LONG).show();
                break;
            case R.id.navigationShare:
                Toast.makeText(this, "'SHARE' menu item was selected!", Toast.LENGTH_LONG).show();
                break;
        }

        drawerLayout.closeDrawer(Gravity.START);

        return true;
    }
}
