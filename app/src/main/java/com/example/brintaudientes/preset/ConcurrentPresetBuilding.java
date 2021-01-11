package com.example.brintaudientes.preset;

public class ConcurrentPresetBuilding extends PresetBuilding {

    protected Preset makePreset(String typeOfPreset) {
        Preset thePreset = null;


        if (typeOfPreset.equals("ONE")) {
            PresetFactory presetPartsFactory = new OneConcurrentPresetFactory();
            thePreset = new OneConcurrentPresetFactory(presetPartsFactory);
            thePreset.setName("Concurrent One-Sound Preset");
        }
        else
            if (typeOfPreset.equals("TWO")) {
            PresetFactory presetPartsFactory = new TwoConcurrentPresetFactory();
            thePreset = new TwoConcurrentPreset(presetPartsFactory);
            thePreset.setName("Concurrent Two-Sound Preset");
        }
            else
            if (typeOfPreset.equals("THREE")) {
                PresetFactory presetPartsFactory = new ThreeConcurrentPresetFactory();
                thePreset = new ThreeConcurrentPreset(presetPartsFactory);
                thePreset.setName("Concurrent Three-Sound Preset");
            }
            else
            if (typeOfPreset.equals("FOUR")) {
                PresetFactory presetPartsFactory = new FourConcurrentPresetFactory();
                thePreset = new FourConcurrentPreset(presetPartsFactory);
                thePreset.setName("Concurrent Four-Sound Preset");
            }
            return thePreset;
    }
}

/*
    @Override
    public PresetFactory getPreset(String presetType) {
        if (presetType.equalsIgnoreCase("TWO")) {
            return new TwoConcurrentPresetFactory();
        }
        else if (presetType.equalsIgnoreCase("Three")) {
            return new ThreeConcurrentPresetFactory();
        }
        else if (presetType.equalsIgnoreCase("FOUR")) {
            return new OneConcurrentPreset();
        }
        else if (presetType.equalsIgnoreCase("ONE")) {
            return new OneConcurrentPresetFactory();
        }
        return null;
    }

 */