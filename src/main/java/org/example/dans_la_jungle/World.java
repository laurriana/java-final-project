package org.example.dans_la_jungle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

public class World {
    private ArrayList<Animal> animauxMorts = new ArrayList<>();
    private ArrayList<Animal> animals = new ArrayList<>();
    private int newbornLions = 0;
    private int newbornAntilopes = 0;
    private double herbe;
    private int tempDeadAnimals = 0; // à revoir
    private byte year = 0;


    public World(int herbeInitial) {
        this.herbe = herbeInitial;
    }

    public byte getYear() {
        return year;
    }

    public void reset() {
        this.animals.clear();
        this.herbe = 0;
        this.year = 0;
        this.newbornLions = 0;
        this.newbornAntilopes = 0;
        this.animauxMorts.clear();
    }

    public double getHerbe() {
        return Math.round(herbe * 100.0) / 100.0;
    }

    public double herbeGrow() {
        if (getHerbe() >= 4000000) {
            return 1000000;
        } else {
            return getHerbe() * 2.2;
        }
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

    public int getNewbornLions() {
        return newbornLions;
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

    public int getNewbornAntilopes() {
        return newbornAntilopes;
    }

    public int getAnimauxMorts() {
        return animauxMorts.size();
    }
    public int getTempDeadAnimals () {
        return tempDeadAnimals;
    } // à revoir

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

        // step 1.1: shuffle
        Random rand = new Random(1);
        Collections.shuffle(animals, rand);

        // step 1.2: (　･ω･)☞ reset newborn counts
        newbornLions = 0;
        newbornAntilopes = 0;
        tempDeadAnimals = 0;

        // step 1.2.1 should we reset the death toll too?


        // step 1.3: make the animals age ٩(ˊ〇ˋ*)و
        for (Animal animal : animals) {
            animal.vieillir();
            if (!animal.isAlive) {
                animauxMorts.add(animal);
            }
        }
        animals.removeAll(animauxMorts);

        // step 1.4: and the grass too (´･ᴗ･ ` )
        herbe = herbeGrow();

        // step 2:  make the animals eat (っ˘ڡ˘ς) lions eat first ? (ง •_•)ง
        for (Animal animal : animals) {
            if (animal.type.equals("Lion")) {
                animal.manger(animals, animauxMorts);
            }
        }

        for (Animal animal : animals) {
            if (animal.type.equals("Antilope")) {
                herbe = ((Antilope) animal).mangerHerbe((int) herbe);
            }
        }

        // step 2.5 manage the dead animals (×﹏×)
        for (Animal animal : animals) {
            if (!animal.isAlive) {
                animauxMorts.add(animal);
                tempDeadAnimals++; // à revoir
            }
        }
        animals.removeAll(animauxMorts);

        // step 3:  make the animals reproduce ( ͡° ͜ʖ ͡°)
        ArrayList<Animal> temp = new ArrayList<>(animals);
        ArrayList<Animal> newborns = new ArrayList<>();

        for (Animal animal : animals) {
            Animal newborn = animal.reproduce(temp, newborns);
            if (newborn != null) {
                temp.add(newborn);
            }
        }

        animals.addAll(newborns);
        manageNewborns();

        // step 4: reset the hasReproduced? ┐('～`;)┌

        // step 5: shuffle again
        Collections.shuffle(animals, rand);
    }

    public void manageNewborns() {
        for (Animal newborn : animals) {
            if (newborn.type.equals("Lion") && newborn.isAlive && newborn.age == 0) {
                newbornLions++;
            } else if (newborn.type.equals("Antilope") && newborn.isAlive && newborn.age == 0) {
                newbornAntilopes++;
            }
        }
    }

}
