/*package com.example.brintaudientes;


import android.app.Activity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import java.io.IOException;
import java.util.ArrayList;

public class Sounds {
    private MediaPlayer playSounds;
    private boolean isPlaying;
    private ArrayList<Integer> sounds;

    public Sounds(MediaPlayer playSounds, Activity activity) {
        this.playSounds = playSounds;

    }

    public void getSounds(int position, Activity activity) {
        isPlaying = true;
        playSounds = new MediaPlayer();
        Uri myUri = Uri.parse("C4-Audientes/app/src/main/res/raw");
        playSounds.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            playSounds.setDataSource(activity, myUri);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sounds = new ArrayList<>();
        for (position = 0; position > 0; position++) {
            sounds.add(position);
            if (sounds.size() == 10) break;
        }

    }
}
*/

