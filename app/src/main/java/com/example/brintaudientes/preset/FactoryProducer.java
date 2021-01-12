package com.example.brintaudientes.preset;

public class FactoryProducer {

    public static AbstractFactory getFactory(boolean continious) {
        if (continious) {
            return new SoundFactory_Continious();
        } else {
            return new SoundFactory_Concurrent();
        }
    }
}


