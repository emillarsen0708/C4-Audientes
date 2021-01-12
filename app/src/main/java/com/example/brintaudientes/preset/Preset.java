/*package com.example.brintaudientes.preset;

public abstract class Preset {

private String name;
private int soundCount;
private ArrayList <String> presetSounds;
private int presetType;

    public static PresetBuilding getFactory(boolean concurrent, boolean continuous) {

        if (concurrent) {
            return new ConcurrentPresetBuilding();
        }
        else if (continuous) {
            return new ContinuousPresetBuilding();
        }
        return null;
    }
}

*/