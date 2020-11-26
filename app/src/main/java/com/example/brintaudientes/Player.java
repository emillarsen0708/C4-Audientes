package com.example.brintaudientes;

// todo: Singleton player (Det er muligvis en rigitg dårlig løsning, hvis vi benytter 4 x player til multisound

public class Player {

    private static Player playerInstance = null;

    private Player () {}

    public static Player getInstance() {
        if (playerInstance == null) {
            playerInstance = new Player();
        }
        return playerInstance;
    }

}
