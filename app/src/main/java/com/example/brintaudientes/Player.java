package com.example.brintaudientes;

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
