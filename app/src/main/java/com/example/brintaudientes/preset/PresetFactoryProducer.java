package com.example.brintaudientes.preset;

public class PresetFactoryProducer {
    public static AbstractFactory getFactory(boolean ambience, boolean sleep) {
        if (ambience) {
            return new AmbiencePresetFactory();
        }
        else if (sleep) {
            return new SleepPresetFactory();
        }
        else {
            return new NoisePresetFactory();
        }
    }
}
