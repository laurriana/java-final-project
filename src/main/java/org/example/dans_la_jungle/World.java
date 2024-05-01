package org.example.dans_la_jungle;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class World {
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList<Animal> animauxMorts = new ArrayList<>();
    private ArrayList<Animal> newbornsAww = new ArrayList<>();

    private double herbe;
    private byte year = 0; // à revoir

    public World(int herbeInitial) {
        this.animals = new ArrayList<>();
        this.herbe = herbeInitial;
    }

    public void reset() {
        this.animals.clear();
        this.herbe = 0;
        this.year = 0;
    }

    // grass methods --> round the grass bcs 10 decimals is CRAZY
    public double getHerbe() {
        return herbe;
    }

    public byte getYear() {
        return year;
    }

    public int getLionCount() {
        int lionCount = 0;
        for (Animal animal : animals) {
            if (Objects.equals(animal.type, "Lion")) { // it's animal.type == "Lion"
                lionCount++;
            }
        }
        return lionCount;
    }

    public int getAntilopeCount() {
        int antilopeCount = 0;
        for (Animal animal : animals) {
            if (Objects.equals(animal.type, "Antilope")) {
                antilopeCount++;
            }
        }
        return antilopeCount;
    }

    public int getAnimauxMorts() {
        return animauxMorts.size();
    }

    public double herbeGrow() {
        if (getHerbe() >= 4000000) {
            return 1000000;
        } else {
            return getHerbe() * 2.2;
        }
    }

    // complicated methods
    public void addAnimal(String animalType, int count) {
        for (int i = 0; i < count; i++) {
            switch (animalType) {
                case "Lion":
                    animals.add(new Lion());
                    break;
                case "Antilope":
                    animals.add(new Antilope());
                    break;
            }
        }
    }

    public void incrementYear() {
        // step 1: increment year
        year++;

        System.out.println("we are at year " + year); // don't forget to remove this line

        // step 1.1: increment age of all animals
        for (Animal furrball : animals) {
            furrball.vieillir();
            if (!furrball.isAlive) {
                animauxMorts.add(furrball);
            }
        }
        animals.removeAll(animauxMorts);

        // step 1.1.1: I guess the grass too
        herbe = herbeGrow();

        // step 2:  make the animals eat ** important **

        /* step 3:  make the animals reproduce
        * if they're 0 at birth make a list for the newborns and dump them in there.
        * but don't forget to remove them (how should I go about it?) this code is getting long so im doing something wrong */



    }

}
