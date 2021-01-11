package com.example.brintaudientes.preset;

public class ThreeConcurrentPresetFactory implements PresetFactory {


    @Override
    public UserName addPresetName() {
        return new ThreePresetName();
    }

    @Override
    public PresetPlayer presetPlayer() {
        return new ThreePresetPlayer();
    }
}
