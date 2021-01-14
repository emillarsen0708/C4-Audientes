package com.example.brintaudientes;


public class SoundModel {

    boolean isSelected;
    int soundPosition;


    public SoundModel(boolean isSelected, int soundPosition) {
        this.isSelected = isSelected;
        this.soundPosition = soundPosition;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public void setSoundPosition(int soundPosition) {
        this.soundPosition = soundPosition;
    }

    public int getSoundPosition() {
        return soundPosition;
    }
}



