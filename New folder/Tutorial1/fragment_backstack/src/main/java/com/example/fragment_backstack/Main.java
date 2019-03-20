package com.example.fragment_backstack;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class Main extends Activity implements FragmentManager.OnBackStackChangedListener {

    private FragmentManager fragmentManager;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.fragmentManager = getFragmentManager();
        this.textView = (TextView) findViewById(R.id.textView);
        this.fragmentManager.addOnBackStackChangedListener(this);
    }

    public void addA(View view) {
        FragmentA fragmentA = new FragmentA();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.linearLayout, fragmentA, "A");
        fragmentTransaction.addToBackStack("addA");
        fragmentTransaction.commit();
    }

    public void removeA(View view) {
        FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("A");
        if (fragmentA != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragmentA);
            fragmentTransaction.addToBackStack("removeA");
            fragmentTransaction.commit();
        }

    }

    public void back(View view){
        this.fragmentManager.popBackStack();
    }

    public void popAndA(View view){
        this.fragmentManager.popBackStack("addA", 0);
    }

   public void popAndA2(View view){
        this.fragmentManager.popBackStack("addA", FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }


    @Override
    public void onBackStackChanged() {
        Log.e("OSE", "123");
        this.textView.setText((this.textView.getText() + "\n"));
        this.textView.setText((this.textView.getText() + "The current status of Back Stack\n"));

        for (int i = fragmentManager.getBackStackEntryCount() - 1; i >= 0; i--) {
            FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
            this.textView.setText((this.textView.getText() + " " + backStackEntry.getName() + "\n"));
        }

        this.textView.setText((this.textView.getText() + "\n"));
    }
}
