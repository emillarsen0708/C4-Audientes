package com.example.brintaudientes;

import java.lang.reflect.Field;
import java.util.ArrayList;

class Sound {
    private Field [] listOfSounds;
    private ArrayList <String> sounds = new ArrayList<>();
    private String soundName;
    private int position;

    public Sound() {
        this.soundName = soundName;
        this.position = position;
    }

    public String getSoundName(int position){
        return listOfSounds[position].getName();
    }

    public ArrayList<String> getSounds(){
        return sounds;
    }

    public void setupSounds (ArrayList <String> sounds) {
        listOfSounds = R.raw.class.getFields();
        for (int i = 0; i < listOfSounds.length; i++) {
            sounds.add(listOfSounds[i].getName());
        }
    }
}
