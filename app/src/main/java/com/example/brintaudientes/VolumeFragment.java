package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;


public class VolumeFragment extends Fragment {

    SeekBar volumes1;
    SeekBar volumes2;
    SeekBar volumes3;

    public VolumeFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_volume, container, false);

        volumes1 = root.findViewById(R.id.volumebars1);
        volumes2 = root.findViewById(R.id.volumebars2);
        volumes3 = root.findViewById(R.id.volumebars3);

    volumes1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            float volumeNum = progress / 100f;

        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    });
        return root;
    }

}