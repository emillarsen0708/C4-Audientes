package com.example.brintaudientes.preset;

public class OneConcurrentPresetFactory implements PresetFactory {


    @Override
    public UserName addPresetName() {
        return new OnePresetName();
    }

    @Override
    public PresetPlayer presetPlayer() {
        return new OnePresetPlayer();
    }
}
