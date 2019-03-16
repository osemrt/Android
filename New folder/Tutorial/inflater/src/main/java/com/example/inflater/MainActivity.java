package com.example.inflater;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import java.util.zip.Inflater;

/**
 * Converting XML appearance definition to View definition in code is called "inflation"
 * (Very time consuming operation!)
 * <p>
 * Use the getSystemService() or getLayoutInflater() to create an object of LayoutInflater
 * Only precompiled XML files by the APPT can be inflated during runtime for performance
 * <p>
 * LayoutInflater layoutInflater = getLayoutInflater();
 * View view = layoutInflater.inflate(int resource, ViewGroup parent);
 * <p>
 * view = the root view representing resource(= also the root in the XML)
 * resource = name of XML layout file that you want to inflate
 * parent(optional) = a layout that you would use as a parent for view in the ViewHierarchy
 */

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LayoutInflater layoutInflater = getLayoutInflater();

        View view;

        LinearLayout linearLayout1 = findViewById(R.id.linearLayout1);
        LinearLayout linearLayout2 = findViewById(R.id.linearLayout2);
        //LinearLayout linearLayout3 = findViewById(R.id.linearLayout3);

        //add the first frame in which is a root to the activity_main.xml
        view = layoutInflater.inflate(R.layout.activity_test, null);
        linearLayout1.addView(view);

        //to directly connect the view with the root
        layoutInflater.inflate(R.layout.activity_test, linearLayout2); // = layoutInflater.inflate(R.layout.activity_test, linearLayout2, true);

        //the representation of using of 3rd parameter
        view = layoutInflater.inflate(R.layout.activity_test, linearLayout1, false);
        linearLayout1.addView(view);

        //how can I access the sub node inside of the view?


    }
}
