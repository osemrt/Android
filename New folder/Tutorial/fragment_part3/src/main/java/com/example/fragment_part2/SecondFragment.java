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

public class SecondFragment extends Fragment implements View.OnClickListener {

    private Communicator communicator;
    private String sender;
    private EditText editText;
    private TextView textView;
    private Button button2;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        communicator = (Communicator) getActivity();
        sender = "SecondFragment";
        editText = (EditText) getActivity().findViewById(R.id.editText2);
        textView = (TextView) getActivity().findViewById(R.id.textView2);
        button2 = (Button) getActivity().findViewById(R.id.button2);
        button2.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textView", textView.getText().toString());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);

        if(savedInstanceState!=null){
            ((TextView)view.findViewById(R.id.textView2)).setText(savedInstanceState.getString("textView"));
        }

        return view;
    }

    public void setTextView(String string){
        textView.setText("Received message: " + string);
    }


    @Override
    public void onClick(View v) {
        communicator.respond(sender + " " + editText.getText().toString());

    }
}
