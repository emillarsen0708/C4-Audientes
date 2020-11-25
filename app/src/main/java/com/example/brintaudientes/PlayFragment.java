package com.example.brintaudientes;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;


public class PlayFragment extends Fragment {

    public PlayFragment() {

    }

    TextView player_position;
    TextView player_duration;
    SeekBar seekBar, volumeBar;
    Button btplay, btpause, btFwd, btBack;
    int totaltime;

    MediaPlayer player;
    Handler mp_handler = new Handler(Looper.myLooper());
    Runnable mp_runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play, container, false);

        player_position = root.findViewById(R.id.player_position);
        player_duration = root.findViewById(R.id.player_duration);
        seekBar = root.findViewById(R.id.seekbar);
        btplay = root.findViewById(R.id.btplay);
        btpause = root.findViewById(R.id.btpause);
        btFwd = root.findViewById(R.id.btFwd);
        btBack = root.findViewById(R.id.btBack);


        player = MediaPlayer.create(getContext(), R.raw.test);

        mp_runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(player.getCurrentPosition());
                mp_handler.postDelayed(this, 500);
            }
        };

        int duration = player.getDuration();
        String sDuration = convertFormat(duration);
        player_duration.setText(sDuration);

        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btplay.setVisibility(View.GONE);
                btpause.setVisibility(View.VISIBLE);
                player.start();
                seekBar.setMax(player.getDuration());
                mp_handler.postDelayed(mp_runnable, 0);
            }
        });

        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btpause.setVisibility(View.GONE);
                btplay.setVisibility(View.VISIBLE);
                player.pause();
                mp_handler.removeCallbacks(mp_runnable);
            }
        });

        btFwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = player.getCurrentPosition();
                int duration = player.getDuration();

                if (player.isPlaying() && duration != currentPosition) {
                    currentPosition = currentPosition + 5000;
                    player_position.setText(convertFormat(currentPosition));
                    player.seekTo(currentPosition);
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = player.getCurrentPosition();

                if (player.isPlaying() && currentPosition > 5000) {
                    currentPosition = currentPosition - 5000;
                    player_position.setText(convertFormat(currentPosition));
                    player.seekTo(currentPosition);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    player.seekTo(progress);
                }
                player_position.setText(convertFormat(player.getCurrentPosition()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btpause.setVisibility(View.GONE);
                btplay.setVisibility(View.VISIBLE);

                player.seekTo(0);
            }
        });
        return root;


    }
    @SuppressLint("DefaultLocale")
    private String convertFormat(int duration) {
        return String.format("%02d:%02d"
                , TimeUnit.MILLISECONDS.toMinutes(duration)
                , TimeUnit.MILLISECONDS.toSeconds(duration) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(duration)));
    }
}