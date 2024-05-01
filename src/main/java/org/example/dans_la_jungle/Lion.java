package org.example.dans_la_jungle;

import java.util.List;

public class Lion extends Animal {
    public Lion() {
        this.lifeExpectancy = 12;
        this.type = "Lion";
    }

    // manger
    @Override
    public void manger() {
        byte antilopesEaten = 0;
//        for (Animal antilope : antilopes) {
//            if (antilope.isAlive) {
//                antilope.isAlive = false;
//                antilopesEaten++;
//                if (antilopesEaten == 2) {
//                    break;
//                }
//            }
//            if (antilopesEaten < 2) {
//                this.isAlive = false; // if the lion didn't eat enough, dies.
//            }
//        }

    }

    // reproduce
    @Override
    public Lion reproduce() {
//        if (age >= 2 && !hasReproduced) {
            return new Lion();
        }
}
