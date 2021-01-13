package com.example.brintaudientes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;


public class VolumeFragment extends Fragment implements View.OnTouchListener {

    private Button adjustButton = null;

    private float x;
    private float y;

    SeekBar volumes1;
    SeekBar volumes2;
    SeekBar volumes3;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_volume, container, false);

        adjustButton = root.findViewById(R.id.adjust_button);
        root.setOnTouchListener(new View.OnTouchListener() {


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                x = event.getX();
                y = event.getY();
                if (event.getAction() == MotionEvent.ACTION_MOVE) {

                    //String xyMsg = String.format("Coordinates: (%. 2f, %2.f)", x, y);
                    //Log.d(AC), xyMsg);

                    adjustButton.setX(x);
                    adjustButton.setY(y);
                }

                return true;
                /*
                Toast.makeText(getActivity().getApplicationContext(), "I was Touched.", Toast.LENGTH_SHORT)
                        .show();
                return true;
            */
            }
        });



        volumes1 = root.findViewById(R.id.volumebars1);
        volumes1.setVisibility(View.GONE);
        volumes2 = root.findViewById(R.id.volumebars2);
        volumes2.setVisibility(View.GONE);
        volumes3 = root.findViewById(R.id.volumebars3);
        volumes3.setVisibility(View.GONE);

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

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return false;
    }
}