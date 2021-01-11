package com.example.brintaudientes.preset;

public class ConcurrentPresetFactory implements PresetFactory {
    @Override
    public void makePreset() {
        System.out.println("Ambience PresetFactory 4 Sound");
    }
}
