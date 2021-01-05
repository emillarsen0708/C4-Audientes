package com.example.brintaudientes.preset;

import android.provider.MediaStore;

public abstract class AbstractFactory {
    abstract Preset getPreset(String presetType);
}
