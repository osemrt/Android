package com.example.fragment_dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

public class Dialog extends DialogFragment implements View.OnClickListener {

    private Button button1;
    private Button button2;
    private Communicator communicator;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.communicator = (Communicator) activity;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        //do not need to pass the container parameter because this dialog is separate from the activity!
        View view = inflater.inflate(R.layout.fragment_dialog, null);
        this.button1 = (Button) view.findViewById(R.id.dismissive);
        this.button2 = (Button) view.findViewById(R.id.affirmative);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        setCancelable(false);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == button1.getId()) {
            communicator.onDialogMessage("No was clicked!");
            dismiss();

        } else if (v.getId() == button2.getId()) {
            communicator.onDialogMessage("Yes was clicked!");
        }
    }


    public interface Communicator {
        abstract public void onDialogMessage(String message);
    }

}
