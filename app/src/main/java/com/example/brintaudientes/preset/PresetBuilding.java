package com.example.brintaudientes.preset;

public abstract class PresetBuilding {

    protected abstract PresetBuilding makePreset(String typeOfPreset);

    public Preset orderThePreset(String typeOfPreset) {
        Preset thePreset = makePreset(typeOfPreset);

        thePreset.makeUserPreset();
        thePreset.metodeEt();
        thePreset.metodeTo();
        thePreset.metodeTre();

        return thePreset;
    }
}
