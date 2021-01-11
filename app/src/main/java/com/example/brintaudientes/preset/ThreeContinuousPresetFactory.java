package com.example.brintaudientes.preset;

public class ThreeContinuousPresetFactory implements PresetFactory {
    @Override
    public void makePreset() {
        System.out.println("Sleep PresetFactory 3 sound");
    }
}
