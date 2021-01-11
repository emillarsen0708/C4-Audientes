package com.example.brintaudientes.preset;

public class OneConcurrentPreset extends Preset {

    PresetFactory pFactory;

    public OneConcurrentPreset(PresetFactory pFactory) {

        this.pFactory = pFactory;
    }

    @Override
    void makeUserPreset() {

        userPresetName = pFactory.addPresetName();
        player = pFactory.presetPlayer();
    }

}
