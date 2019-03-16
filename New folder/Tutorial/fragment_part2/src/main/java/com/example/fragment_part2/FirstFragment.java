package com.example.fragment_part2;


import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment implements View.OnClickListener {

    private TextView textView;
    private EditText editText;
    private Communicator communicator;
    private String sender;
    private Button button1;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        textView = (TextView) getActivity().findViewById(R.id.textView1);
        editText = (EditText) getActivity().findViewById(R.id.editText1);
        communicator = (Communicator) getActivity();
        sender = "FirstFragment";
        button1 = (Button) getActivity().findViewById(R.id.button1);
        button1.setOnClickListener(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }


    public void setTextView(String string) {
        textView.setText("Received message: " + string);
    }

    @Override
    public void onClick(View v) {
        communicator.respond(sender + " " + editText.getText().toString());
    }
}
