package com.example.brintaudientes.preset;

// create factory class extending AbstractFactory to generate object to concrete class based on
// given information
public class SoundFactory_Continious extends AbstractFactory {
    @Override
    public Sound getSound(String soundType) {
        if (soundType.equalsIgnoreCase("Continious")) {
            return new Continious();
        } else
            return null;
    }
}
