package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class PlayContainer extends Fragment {



    public PlayContainer() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_play_container, container, false);;

        FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
        transaction.replace(R.id.playContainer, new PlayFragment());
        transaction.commit();


        return root;
    }
}