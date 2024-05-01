package org.example.dans_la_jungle;

import java.util.ArrayList;

public class Antilope extends Animal {
    public Antilope() {
        this.lifeExpectancy = 10;
        this.type = "Antilope";
    }

    public int mangerHerbe(int herbeDispo) {
        return herbeDispo - 100;
    }

    // reproduce
    @Override
    public void reproduce(ArrayList<Animal> animals) {
//        if (age >= 2 && !hasReproduced) {
//        return new Antilope();
        /*
            1. cannot be the same animal (no selfcest)
            2. gotta be of age
            3. not reproduce
            4. gotta be the same for the partner
            5. change the hasReproduced
            6. @ end of year, changed hasReproduced back to false
         */

    }

}

