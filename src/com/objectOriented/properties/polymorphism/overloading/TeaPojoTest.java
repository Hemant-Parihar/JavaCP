package com.objectOriented.properties.polymorphism.overloading;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TeaPojoTest {
    @Test
    public void whenTeaWithOnlyName_thenCreateDefaultTea() {
        TeaPojo blackTea = new TeaPojo("Black Tea");

        assertEquals(blackTea.getName(), "Black Tea");
        assertEquals(blackTea.getMilk(), 0);
        assertEquals(blackTea.isHerbs(), false);
        assertEquals(blackTea.getSugar(), 0);
        assertEquals(blackTea.getTeaPowder(), TeaPojo.DEFAULT_TEA_POWDER);
    }

}