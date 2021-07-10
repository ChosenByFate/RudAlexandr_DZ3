package aviary;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T> {
    private int aviarySize;
    private int aviaryFullness = 0;
    private HashMap<Integer, T> animals = new HashMap<>();

    public int getSize() {
        return aviarySize;
    }

    public int getAviaryFullness() {
        return aviaryFullness;
    }

    public Aviary(int size){
        this.aviarySize = size;
    }

    public void setSize(int size) {
        if (animals.size() != 0) {
            System.out.println("You can't change aviary size while there are animals in it.");
            return;
        }
        this.aviarySize = size;
        System.out.println("New size: " + this.aviarySize);
    }

    public void setAnimals(HashMap<Integer, T> animals) {
        this.animals = animals;
    }

    public void addAnimal(T animal){
        final int animalSize = ((Animal)animal).getAviarySize().getSize();
        if (animalSize <= aviarySize && animalSize <= aviarySize - aviaryFullness ) {
            if (this.animals.put(animal.hashCode(), animal) == null) {
                System.out.println("Adding animal with key: " + animal.hashCode());
                aviaryFullness += animalSize;
            }
            else
                System.out.println("Animal with key: " + animal.hashCode() + " already exists.");
        }
        else
            System.out.println("Not enough space in this aviary.");
    }

    public void removeAnimal(T animal){
        if (this.animals.remove(animal.hashCode()) != null) {
            aviaryFullness -= ((Animal)animal).getAviarySize().getSize();
            System.out.println("Removing animal with key: " + animal.hashCode());
        }
        else
            System.out.println("Animal with key: " + animal.hashCode() + " not found.");
    }

    public void removeAnimal(String name){
        System.out.println("Removing animal with key: " + name.hashCode());
        this.animals.remove(name.hashCode());
    }

    public T getAnimal(String name){
        return this.animals.get(name.hashCode());
    }

    public int animalsCount() {
        return animals.size();
    }
}
