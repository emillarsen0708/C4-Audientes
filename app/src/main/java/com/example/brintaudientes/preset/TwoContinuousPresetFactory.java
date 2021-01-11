package com.example.brintaudientes.preset;

public class TwoContinuousPresetFactory implements PresetFactory {
    @Override
    public void makePreset() {
        System.out.println("Sleep PresetFactory 2 sound");
    }
}
