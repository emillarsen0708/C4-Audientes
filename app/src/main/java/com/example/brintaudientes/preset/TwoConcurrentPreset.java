package com.example.brintaudientes.preset;

public class TwoConcurrentPreset extends Preset {

    PresetFactory pFactory;

    public TwoConcurrentPreset(PresetFactory pFactory) {
         this.pFactory = pFactory;
    }

    @Override
    void makeUserPreset() {

        userPresetName = pFactory.addPresetName();
        player = pFactory.presetPlayer();

    }
}
