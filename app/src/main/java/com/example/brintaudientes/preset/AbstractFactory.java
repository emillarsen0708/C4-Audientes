package com.example.brintaudientes.preset;

public abstract class AbstractFactory {

    // get factories for Concurrent and Continious sound objects.
    abstract Sound getSound(String soundType);

}
