
package com.example.brintaudientes.players;

public class Player implements PlayerPlan {

    private int playerSound;
    private int playerVolume;
    private int playerPosition;
    private boolean playerLooper;
    private String playerTitle;

    @Override
    public void setPlayerSound(int sound) {

        playerSound = sound;
    }


    @Override
    public void setPlayerVolume(int volume) {

        playerVolume = volume;
    }

    public int getPlayerVolume() {
        return playerVolume;

    @Override
    public void setPlayerPosition(int position) {

        playerPosition = position;

    }

        public int getPlayerPosition() {
            return playerPosition;

        }

    @Override
    public void setPlayerLooper(boolean looper) {

        playerLooper = looper;
    }

    @Override
    public void setPresetTitel(String titel) {

        playerTitle = titel;
    }
}