package org.example.dans_la_jungle;

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
        // this gotta be wrong
        if (age >= 2 && !hasReproduced) {
            System.out.println("nothing here yet");
        }
        return null;
    }

    public void manger() {
        System.out.println("yasss girl we eating good"); // don't forget to remove this line too
    }
}
