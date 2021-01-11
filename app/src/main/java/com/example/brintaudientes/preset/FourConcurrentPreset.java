package com.example.brintaudientes.preset;

public class FourConcurrentPreset extends Preset {

    PresetFactory pFactory;

    public FourConcurrentPreset(PresetFactory pFactory) {
        this.pFactory = pFactory;
    }

    @Override
    void makeUserPreset() {

        userPresetName = pFactory.addPresetName();
        player = pFactory.presetPlayer();
    }
}
