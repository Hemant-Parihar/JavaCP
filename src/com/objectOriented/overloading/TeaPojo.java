package com.objectOriented.overloading;

public class TeaPojo {

    static final int DEFAULT_TEA_POWDER = 1;

    private String name;
    private int milk;
    private boolean herbs;
    private int sugar;
    private int teaPowder;

    public TeaPojo(String name, int milk, boolean herbs, int sugar, int teaPowder) {
        this.name = name;
        this.milk = milk;
        this.herbs = herbs;
        this.sugar = sugar;
        this.teaPowder = teaPowder;
    }

    public TeaPojo(String name, int milk, boolean herbs, int sugar) {
        this(name, milk, herbs, sugar, DEFAULT_TEA_POWDER);
    }

    public TeaPojo(String name, int milk, boolean herbs) {
        this(name, milk, herbs, 0);
    }

    public TeaPojo(String name, int milk) {
        this(name, milk, false);
    }

    public TeaPojo(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getMilk() {
        return milk;
    }

    public boolean isHerbs() {
        return herbs;
    }

    public int getSugar() {
        return sugar;
    }

    public int getTeaPowder() {
        return teaPowder;
    }
}
