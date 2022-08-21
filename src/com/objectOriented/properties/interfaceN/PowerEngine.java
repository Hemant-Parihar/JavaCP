package com.objectOriented.properties.interfaceN;

public class PowerEngine implements Engine{

    @Override
    public void start() {
        System.out.println("Staring Engine");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Engine");
    }
}
