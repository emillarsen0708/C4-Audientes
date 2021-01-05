package com.example.brintaudientes;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.KeyEvent;
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
    SeekBar seekBar, volumeBar1, volumeBar2, volumeBar3;
    Button btplay, btpause, btFwd, btBack, preset;
    int tracktimep1;
    int tracktimep2;

    MediaPlayer player1;
    MediaPlayer player2;
    MediaPlayer player3;

    Handler mp1_handler = new Handler(Looper.myLooper());

    Runnable mp1_runnable;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_play, container, false);

        preset = root.findViewById(R.id.mode_button);

        player_position = root.findViewById(R.id.player_position);
        player_duration = root.findViewById(R.id.player_duration);
        seekBar = root.findViewById(R.id.seekbar);
        volumeBar1 = root.findViewById(R.id.volumebar1);
        volumeBar2 = root.findViewById(R.id.volumebar2);
        volumeBar3 = root.findViewById(R.id.volumebar3);
        btplay = root.findViewById(R.id.btplay);
        btpause = root.findViewById(R.id.btpause);
        btFwd = root.findViewById(R.id.btFwd);
        btBack = root.findViewById(R.id.btBack);



        player1 = MediaPlayer.create(getContext(), R.raw.bee_buzzing);
        player2 = MediaPlayer.create(getContext(), R.raw.pack_of_dogs);
        player3 = MediaPlayer.create(getContext(), R.raw.cicada);

        player1.setLooping(true);
        player2.setLooping(true);
        player3.setLooping(true);

        player1.setVolume(0.5f, 0.5f); // Todo: få panorering til at være permanent
        player2.setVolume(0.0f, 0.5f);
        player3.setVolume(0.5f, 0.5f);

        player1.seekTo(0);
        player2.seekTo(0);
        player3.seekTo(0);

        tracktimep1 = player1.getDuration();  //Todo: Få resterende tid til at fungere
        player_duration.setText(convertFormat(tracktimep1));

        mp1_runnable = new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(player1.getCurrentPosition());
                mp1_handler.postDelayed(this, 500);
            }
        };

        preset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                preset.setVisibility(View.GONE);
                btplay.setVisibility(View.GONE);
                btpause.setVisibility(View.GONE);
                btFwd.setVisibility(View.GONE);
                btBack.setVisibility(View.GONE);

                AmbienceFragment ambienceFragment = new AmbienceFragment();

                FragmentManager manager = getParentFragmentManager();
                manager.beginTransaction()
                        .replace(R.id.frontpage, ambienceFragment, ambienceFragment.getTag())
                        .commit();
            }

        });

        btplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btplay.setVisibility(View.GONE);
                btpause.setVisibility(View.VISIBLE);
                player1.start();
                player2.start();
                player3.start();
                seekBar.setMax(tracktimep1);
                mp1_handler.postDelayed(mp1_runnable, 0);
            }
        });

        btpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btpause.setVisibility(View.GONE);
                btplay.setVisibility(View.VISIBLE);
                player1.pause();
                player2.pause();
                player3.pause();
                mp1_handler.removeCallbacks(mp1_runnable);
            }
        });

        btFwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = player1.getCurrentPosition();
                int duration = player1.getDuration();

                if (player1.isPlaying() && duration != currentPosition) {
                    currentPosition = currentPosition + 5000;
                    player_position.setText(convertFormat(currentPosition));
                    player1.seekTo(currentPosition);
                }
            }
        });

        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentPosition = player1.getCurrentPosition();

                if (player1.isPlaying() && currentPosition > 5000) {
                    currentPosition = currentPosition - 5000;
                    player_position.setText(convertFormat(currentPosition));
                    player1.seekTo(currentPosition);
                }
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (fromUser) {
                    player1.seekTo(progress);
                    seekBar.setProgress(progress);
                }
              player_position.setText(convertFormat(player1.getCurrentPosition()));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        volumeBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float volumeNum = progress / 100f;
                player1.setVolume(volumeNum, volumeNum);
                if (fromUser) {

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        volumeBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float volumeNum = progress / 100f;
                player2.setVolume(volumeNum, volumeNum);
                if (fromUser) {
                    
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        volumeBar3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float volumeNum = progress / 100f;
                player3.setVolume(volumeNum, volumeNum);
                if (fromUser) {

                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        player1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                btpause.setVisibility(View.GONE);
                btplay.setVisibility(View.VISIBLE);

                player1.seekTo(0);
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

/*

*/

/*
        btplay = (Button) findViewById(R.id.btplay);
        player_position = (TextView) findViewById(R.id.player_position);
        player_duration = (TextView) findViewById(R.id.player_duration);

        player = MediaPlayer.create(this, R.raw.lyd);
        player.setLooping(true);
        player.setVolume(0.5f, 0.5f);
        player.seekTo(0);
        totaltime = player.getDuration();

        seekBar = (SeekBar) findViewById(R.id.seekbar);
        seekBar.setMax(totaltime);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        if (fromUser) {
                            player.seekTo(progress);
                            seekBar.setProgress(progress);
                        }
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });

        volumeBar = (SeekBar) findViewById(R.id.volumebar);
        volumeBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                        float volumeNum = progress / 100f;
                        player.setVolume(volumeNum, volumeNum);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });



    }

    public void btplayClick(View v) {

        if(!player.isPlaying()) {
            player.start();
            btplay.setBackgroundResource(R.drawable.pause_button);

        }
        else {
            player.pause();
            btplay.setBackgroundResource(R.drawable.play_button);
        }
    }
*/





