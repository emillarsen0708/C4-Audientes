package com.example.brintaudientes.preset;

public class NoisePresetFactory extends AbstractFactory {
    @Override
    public Preset getPreset(String presetType) {
        if (presetType.equalsIgnoreCase("WHITE")) {
            return new WhiteNoisePreset();
        }
        else if (presetType.equalsIgnoreCase("PINK")) {
            return new PinkNoisePreset();
        }
        else if (presetType.equalsIgnoreCase("BROWN")) {
            return new BrownNoisePreset();
        }
        return null;
    }
}
