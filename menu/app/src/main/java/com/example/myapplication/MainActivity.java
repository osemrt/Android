package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id){
            case R.id.action_settings:
                Toast.makeText(this, "Settings", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_about:
                Toast.makeText(this, "About", Toast.LENGTH_LONG).show();
                break;
            case R.id.action_contact:
                Toast.makeText(this, "Contact", Toast.LENGTH_LONG).show();
                break;
                default:
                    Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show();
        }

        return true;

    }


}
