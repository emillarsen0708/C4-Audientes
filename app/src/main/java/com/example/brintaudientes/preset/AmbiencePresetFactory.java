package com.example.brintaudientes.preset;

public class AmbiencePresetFactory extends AbstractFactory {
    @Override
    public Preset getPreset(String presetType) {
        if (presetType.equalsIgnoreCase("TWO")) {
            return new TwoSoundAmbPreset();
        }
        else if (presetType.equalsIgnoreCase("Three")) {
            return new ThreeSoundAmbPreset();
        }
        else if (presetType.equalsIgnoreCase("FOUR")) {
            return new FourSoundAmbPreset();
        }
        else if (presetType.equalsIgnoreCase("ONE")) {
            return new OneSoundAmbPreset();
        }
        return null;
    }
}
