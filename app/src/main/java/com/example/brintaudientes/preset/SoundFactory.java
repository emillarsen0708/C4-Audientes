package com.example.brintaudientes.preset;

public class SoundFactory extends AbstractFactory {
    @Override
    public Sound getSound(String soundType) {
        if (soundType.equalsIgnoreCase("Nature")) {
            return new Nature();
        }else if (soundType.equalsIgnoreCase("Animal")){
            return new Animal();
        }

        return null;
    }
}
