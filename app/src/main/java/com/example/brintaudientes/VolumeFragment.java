
package com.example.brintaudientes;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import java.sql.Struct;


public class VolumeFragment extends Fragment implements View.OnTouchListener {

    private LinearLayout volumeLayout;
    private Button adjustButton = null;
    private float x;
    private float y;

    Handler vol1_handler = new Handler(Looper.myLooper());
    Handler vol2_handler = new Handler(Looper.myLooper());
    Handler vol3_handler = new Handler(Looper.myLooper());
    Handler vol4_handler = new Handler(Looper.myLooper());

    Runnable vol1_runnable;
    Runnable vol2_runnable;
    Runnable vol3_runnable;
    Runnable vol4_runnable;

    MediaPlayer mediaPlayer1;

    SeekBar volumes1;
    SeekBar volumes2;
    SeekBar volumes3;
    SeekBar volumes4;

    PresetFragment presetFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_volume, container, false);

        volumeLayout = root.findViewById(R.id.preset_quick);
        adjustButton = root.findViewById(R.id.adjust_button);

        volumeLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                x = event.getX();
                y = event.getY();

                if (event.getAction() == MotionEvent.ACTION_MOVE) {

                    adjustButton.setX(x);
                    adjustButton.setY(y);

                }
                return true;
            }
        });


        volumes1 = root.findViewById(R.id.volumebars1);
        volumes1.setVisibility(View.GONE);


        vol1_runnable = new Runnable() {
            @Override
            public void run() {
                vol1_handler.postDelayed(this, 100);
            }
        };

        volumes2 = root.findViewById(R.id.volumebars2);
        volumes2.setVisibility(View.GONE);
        volumes3 = root.findViewById(R.id.volumebars3);
        volumes3.setVisibility(View.GONE);
        volumes4 = root.findViewById(R.id.volumebars3);
        volumes4.setVisibility(View.GONE);




    volumes1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

           // PresetFragment.mediaPlayer2.setVolume(0.5f, 0.5f);
           // PresetFragment.mediaPlayer3.setVolume(0.5f, 0.5f);
           // PresetFragment.mediaPlayer4.setVolume(0.5f, 0.5f);
//


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
