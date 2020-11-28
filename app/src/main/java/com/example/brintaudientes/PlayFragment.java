package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class PlayFragment extends Fragment {
    private Button select_mode;

    public PlayFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play, container, false);

        select_mode = root.findViewById(R.id.mode_button);

        select_mode.setOnClickListener((View.OnClickListener) this);

        @Override
                public void onClick (View root)

    }
}