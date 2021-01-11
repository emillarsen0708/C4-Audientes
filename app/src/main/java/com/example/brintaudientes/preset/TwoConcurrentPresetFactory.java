package com.example.brintaudientes.preset;

public class TwoConcurrentPresetFactory implements PresetFactory {


    @Override
    public UserName addPresetName() {
        return new TwoPresetName();
    }

    @Override
    public PresetPlayer presetPlayer() {
        return new TwoPresetPlayer();
    }
}
