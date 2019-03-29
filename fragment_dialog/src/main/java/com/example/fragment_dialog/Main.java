package com.example.fragment_dialog;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Main extends Activity implements Dialog.Communicator {

    private FragmentManager fragmentManager;
    private TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = (TextView) findViewById(R.id.textView);
    }


    public void showDialog(View view) {
        this.fragmentManager = getFragmentManager();
        Dialog dialog = new Dialog();
        dialog.show(fragmentManager, "fragment_dialog");

    }

    @Override
    public void onDialogMessage(String message) {
        textView.setText(message);
    }
}
