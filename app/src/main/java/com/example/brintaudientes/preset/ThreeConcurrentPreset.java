package com.example.brintaudientes.preset;

public class ThreeConcurrentPreset extends Preset {

    PresetFactory pFactory;

    public ThreeConcurrentPreset(PresetFactory pFactory) {
        this.pFactory = pFactory;
    }

    @Override
    void makeUserPreset() {

        userPresetName = pFactory.addPresetName();
        player = pFactory.presetPlayer();
    }
}
