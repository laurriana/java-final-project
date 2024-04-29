package org.example.dans_la_jungle;
import java.util.ArrayList;
import java.util.Objects;

public class World {
    private ArrayList<Animal> animals = new ArrayList<>();

    private int herbe;
    private byte year = 0; // à revoir

    public World(int herbeInitial) {
        this.animals = new ArrayList<>();
        this.herbe = herbeInitial;
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


    public double getHerbe() {
        return herbe;
    }


    public int animauxMorts() {
        int deadAnimals = 0;
        for (Animal animal : animals) {
            if (!animal.isAlive) {
                deadAnimals++;
            }
        } return deadAnimals;
    }


    // complicated methods
    public void addAnimal(Animal animal, int count) {
        for (int i = 0; i < count; i++) {
            animals.add(animal);
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

        // step 1.1: increment age of all animals
        for (Animal animal : animals) {
            animal.vieillir();

            // 1.2: gestion des animaux morts
            if (!animal.isAlive) {
                animals.remove(animal);
            }
//            animal.manger();
//        }
//        // step 2: make the animals eat and reproduce
//        for (Animal animal : animals) {
//            animal.manger();
//            animal.reproduce();
//        }
        }

    }

}
