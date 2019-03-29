package com.example.fragment_flexible_user_interface_2;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

public class FirstFragment extends Fragment implements AdapterView.OnItemClickListener {
    private ListView listView;
    private Communicator communicator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        this.listView = (ListView) getActivity().findViewById(R.id.listView);
        this.listView.setOnItemClickListener(this);
    }


    //
    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        communicator.respond(position);
    }


    public interface Communicator {
        abstract public void respond(int position);
    }

}
