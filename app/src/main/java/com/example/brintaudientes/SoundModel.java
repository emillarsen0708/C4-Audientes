package com.example.brintaudientes;


import java.lang.reflect.Field;

public class SoundModel {

    boolean isSelected;
    String soundName;

    public SoundModel(boolean isSelected, String soundName) {
        this.isSelected = isSelected;
        this.soundName = soundName;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setSoundName(String soundName) {
        this.soundName = soundName;
    }

    public String getSoundName() {
        return soundName;
    }
}



