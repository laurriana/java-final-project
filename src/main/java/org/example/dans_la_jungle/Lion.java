package org.example.dans_la_jungle;

import java.util.ArrayList;

public class Lion extends Animal {
    public Lion() {
        this.lifeExpectancy = 12;
        this.type = "Lion";
    }

    // manger
    @Override
    public void manger(ArrayList<Animal> animals, ArrayList<Animal> animauxMorts) {
        byte antilopesAte = 0;

        for (Animal animal : animals) {
            if (animal.type.equals("Antilope") && animal.isAlive) {
                animal.isAlive = false;
                antilopesAte++;
                if (antilopesAte == 2) {
                    break;
                }
            }
        }
    }

    // reproduce
    @Override
    public Lion reproduce(ArrayList<Animal> animals, ArrayList<Animal> newborns) {
        if (age >= 2 && !hasReproduced) {
            for (Animal animal : animals) {
                if (animal.type.equals("Lion") && !animal.hasReproduced && animal.age >= 2 && !animal.equals(this) && animal.isAlive) {
                    animal.hasReproduced = true;
                    hasReproduced = true;
                    Lion newborn = new Lion();
                    newborns.add(newborn);
                    return newborn;
                }
            }
        }
        return null;
    }
}
