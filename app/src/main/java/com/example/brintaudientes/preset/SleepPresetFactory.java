package com.example.brintaudientes.preset;

public class SleepPresetFactory extends AbstractFactory {
    @Override
    public Preset getPreset(String presetType) {
        if (presetType.equalsIgnoreCase("ONE")) {
            return new OneSoundSleepPreset();
        }
        else if (presetType.equalsIgnoreCase("TWO")) {
            return new TwoSoundSleepPreset();
        }
        else if (presetType.equalsIgnoreCase("THREE")) {
            return new ThreeSoundSleepPreset();
        }
        else if (presetType.equalsIgnoreCase("FOUR")) {
            return new FourSoundSleepPreset();
        }
        return null;
    }
}
