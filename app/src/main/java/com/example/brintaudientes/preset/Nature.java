package com.example.brintaudientes.preset;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;

import com.example.brintaudientes.R;

import java.lang.reflect.Field;
import java.text.Format;
import java.util.ArrayList;

public class Nature implements Sound {
    private ArrayList<String> listOfSongs;

    @Override
    public void getSound() {
        listOfSongs = new ArrayList<String>();
        Field[] fields = R.raw.class.getFields();
        for (int i = 0; i < fields.length; i++) {
            listOfSongs.add(fields[i].getName());

        }
    }
}
