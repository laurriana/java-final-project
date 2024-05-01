package org.example.dans_la_jungle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class World {
    private ArrayList<Animal> animals = new ArrayList<>();
    private ArrayList <Animal> animauxMorts = new ArrayList<>();

    private int herbe;
    private byte year = 0; // à revoir

    public World(int herbeInitial) {
        this.animals = new ArrayList<>();
        this.herbe = herbeInitial;
    }

    public double getHerbe() {
        return herbe;
    }

    public byte getYear() {
        return year;
    }

    // i need a getLionCount() method and a getAntilopeCount() method

    public int getLionCount() {
        int lionCount = 0;
        for ( Animal animal : animals ) {
            if (Objects.equals(animal.type, "Lion")) { // it's animal.type == "Lion"
                lionCount++;
            }
        } return lionCount;
    }

    public int getAntilopeCount() {
        int antilopeCount = 0;
        for ( Animal animal : animals ) {
            if (Objects.equals(animal.type, "Antilope")) {
                antilopeCount++;
            }
        } return antilopeCount;
    }

    public int getAnimauxMorts() {
        return animauxMorts.size();
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

    public void reset() {
        this.animals.clear();
        this.herbe = 0;
        this.year = 0;
    }

    public void incrementYear() {
        // step 1: increment year
        year++;
        System.out.println("we are at year " + year);

        // step 1.1: increment age of all animals
        List<Animal> deadAnimals = new ArrayList<>();
        for (Animal rawrXD : animals) {
            rawrXD.vieillir();
            if (!rawrXD.isAlive) {
                deadAnimals.add(rawrXD);
            }
        }
        animals.removeAll(deadAnimals);

        // step 2: make the animals eat and reproduce

    }

}
