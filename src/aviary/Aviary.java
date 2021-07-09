package aviary;

import animals.Animal;

import java.util.HashMap;

public class Aviary<T> {
    private AviarySize size;
    private HashMap<Integer, T> animals = new HashMap<>();

    public Aviary(AviarySize size){
        this.size = size;
    }

    public AviarySize getSize() {
        return size;
    }

    public void setSize(AviarySize size) {
        if (animals.size() != 0) {
            System.out.println("You can't change aviary size while there are animals in it.");
            return;
        }
        this.size = size;
        System.out.println("New size: " + this.size);
    }

    public void setAnimals(HashMap<Integer, T> animals) {
        this.animals = animals;
    }

    public void addAnimal(T animal){
        if (((Animal)animal).getAviarySize() == size) {
            System.out.println("Adding animal with key: " + animal.hashCode());
            this.animals.put(animal.hashCode(), animal);
        }
        else
            System.out.println("Wrong size.");
    }

    public void removeAnimal(T animal){
        System.out.println("Removing animal with key: " + animal.hashCode());
        this.animals.remove(animal.hashCode());
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
