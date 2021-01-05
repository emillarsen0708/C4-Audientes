package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;


public class SettingsFragment extends Fragment {

    SeekBar volumes1;
    SeekBar volumes2;
    SeekBar volumes3;
    Button preset;

    public SettingsFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        volumes1 = (SeekBar) root.findViewById(R.id.volumebars1);
        volumes2 = (SeekBar) root.findViewById(R.id.volumebars2);
        volumes3 = (SeekBar) root.findViewById(R.id.volumebars3);

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