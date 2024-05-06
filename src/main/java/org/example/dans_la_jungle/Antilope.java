package org.example.dans_la_jungle;

import java.util.ArrayList;

public class Antilope extends Animal {
    public Antilope() {
        this.lifeExpectancy = 10;
        this.type = "Antilope";
    }

    public int mangerHerbe(int herbeDispo) {
        if (!this.isAlive) { // a dead antilope can't eat
            System.out.println("a dead antilope can't eat </3");
            return herbeDispo;
        } else if (herbeDispo < 100) { // not enough grass for the antilope to eat
            System.out.println("not enough grass for the antilope to eat");
            return herbeDispo;
    } else {
            return herbeDispo - 100;
        }
    }

    // reproduce
    @Override
    public Antilope reproduce(ArrayList<Animal> animals, ArrayList<Animal> newborns) {
        if (age >= 2 && !hasReproduced) {
            for (Animal animal : animals) {
                if (animal.type.equals("Antilope") && !animal.hasReproduced && animal.age >= 2 && !animal.equals(this) && animal.isAlive) {
                    animal.hasReproduced = true;
                    hasReproduced = true;
                    Antilope newborn = new Antilope();
                    newborns.add(newborn);
                    return newborn;
                }
            }
        }
        return null;
    }

}

