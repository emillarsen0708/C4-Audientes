package com.example.brintaudientes.preset;

public abstract class AbstractFactory {

    // get factories for Nature and Animal sound objects.
    abstract Sound getSound(String soundType);

}
