package com.objectOriented.properties.interfaceN;

public class Car{
    private PowerEngine engine;
    private CDPlayer player;

    public Car() {
        this.engine = new PowerEngine();
        this.player = new CDPlayer();
    }

    public Car(PowerEngine engine, CDPlayer player) {
        this.engine = engine;
        this.player = player;
    }
}
