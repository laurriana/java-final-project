package org.example.dans_la_jungle;

public class Antilope extends Animal {
    public Antilope() {
        this.lifeExpectancy = 10;
        this.type = "Antilope";
    }

    public int mangerHerbe(int herbeDispo) {
        return herbeDispo - 100;
    }

}
