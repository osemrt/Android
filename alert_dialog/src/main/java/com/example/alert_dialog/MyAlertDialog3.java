package com.example.alert_dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MyAlertDialog3 extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Title1");
        builder.setMultiChoiceItems(R.array.days, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                Toast.makeText(getActivity(), getActivity().getResources().getStringArray(R.array.days)[which] + " " + Boolean.toString(isChecked), Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });

        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getActivity(), "Ok was selected!", Toast.LENGTH_LONG).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        return alertDialog;
    }
}
