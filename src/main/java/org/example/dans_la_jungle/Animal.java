package org.example.dans_la_jungle;

import java.util.List;

public abstract class Animal {
    protected byte age = 0;
    protected boolean isAlive = true;
    protected boolean hasReproduced = false;

    protected byte lifeExpectancy;
    protected String type;


    // complex methods
    public void vieillir() {
        age++;
        System.out.println(type + " aged. Current age: " + age + "\nYears left to live: " + (lifeExpectancy - age));
        if (age >= lifeExpectancy) {
            isAlive = false;
        }
    }

    public Animal reproduce() {
        if (age >= 2 && !hasReproduced) {
            hasReproduced = true;
            return switch (this.type) {
                case "Lion" -> new Lion();
                case "Antilope" -> new Antilope();
                default -> null;
            };
        }
        return null;
    }

    public void manger() {
        System.out.println("yasss bitch we eating good");
    }
}
