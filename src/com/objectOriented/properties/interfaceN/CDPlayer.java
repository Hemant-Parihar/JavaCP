package com.objectOriented.properties.interfaceN;

public class CDPlayer implements MusicPlayer{
    @Override
    public void start() {
        System.out.println("Starting Music");
    }

    @Override
    public void stop() {
        System.out.println("Stopping Music");
    }
}
