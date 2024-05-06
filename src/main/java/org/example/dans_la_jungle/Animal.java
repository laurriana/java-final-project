package org.example.dans_la_jungle;

import java.util.ArrayList;

public class Animal {
    protected byte age = 0;
    protected boolean isAlive = true;
    protected boolean hasReproduced = false;

    protected byte lifeExpectancy;
    protected String type;

    public void vieillir() {
        age++;
        if (age == lifeExpectancy) {
            isAlive = false;
        }
    }

    public Animal reproduce(ArrayList<Animal> animals, ArrayList<Animal> newborns) {
        return null;
    }

    public void manger(ArrayList<Animal> animals, ArrayList<Animal> animauxMorts) {

    }
}
