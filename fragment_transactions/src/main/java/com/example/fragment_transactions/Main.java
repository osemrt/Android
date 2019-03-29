package com.example.fragment_transactions;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Main extends Activity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.fragmentManager = getFragmentManager();
    }


    public void addA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayout, fragmentA, "A");
        fragmentTransaction.commit();

    }

    public void removeA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "The fragment A was not added before!", Toast.LENGTH_LONG).show();
        }


    }

    public void replaceAB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.linearLayout, fragmentB, "B");
        fragmentTransaction.commit();
    }

    public void addB(View view) {
        FragmentB fragmentB = new FragmentB();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayout, fragmentB, "B");
        fragmentTransaction.commit();

    }

    public void removeB(View view) {
        FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("B");
        if (fragmentB != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentB);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "The fragment B was not added before!", Toast.LENGTH_LONG).show();
        }

    }

    public void replaceBA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.linearLayout, fragmentA, "A");
        fragmentTransaction.commit();
    }

    //to show the fragment
    public void attachA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(fragmentA);
            fragmentTransaction.commit();

        }

    }

    //to hide the fragment
    public void detachA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(fragmentA);
            fragmentTransaction.commit();
        }

    }


}
