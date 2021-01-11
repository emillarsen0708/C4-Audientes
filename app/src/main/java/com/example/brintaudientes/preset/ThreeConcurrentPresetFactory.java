package com.example.brintaudientes.preset;

public class ThreeConcurrentPresetFactory implements PresetFactory {
    @Override
    public void makePreset() {
        System.out.println("Ambience PresetFactory 3 Sound");
    }
}
