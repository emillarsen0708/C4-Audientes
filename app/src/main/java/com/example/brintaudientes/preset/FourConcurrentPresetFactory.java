package com.example.brintaudientes.preset;

public class FourConcurrentPresetFactory implements PresetFactory {


    @Override
    public UserName addPresetName() {
        return new FourPresetName();
    }

    @Override
    public PresetPlayer presetPlayer() {
        return new FourPresetPlayer();
    }
}
