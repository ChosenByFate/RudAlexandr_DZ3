import animals.*;
import aviary.Aviary;
import aviary.AviarySize;
import exceptions.WrongFoodException;
import food.*;

public class Application {
    public static void main(String[] args) {

        Aviary<Herbivore> aviaryHerbivore = new Aviary<>(AviarySize.MAX);
        aviaryHerbivore.addAnimal(new Deer("Hyena", AviarySize.MAX));
        aviaryHerbivore.addAnimal(new Duck("Duck", AviarySize.MAX));
        aviaryHerbivore.addAnimal(new EurasianHoopoe("EurasianHoopoe", AviarySize.MIN));
//        aviaryHerbivore.addAnimal(new Hawk("Hawk", AviarySize.MAX));  // You can't push Carnivorous to Herbivore!
        Duck duck = new Duck("Ducky", AviarySize.MAX);
        aviaryHerbivore.addAnimal(duck);
        aviaryHerbivore.removeAnimal(duck);
        System.out.println("__________________________________________________");

        Aviary<Carnivorous> aviaryCarnivorous = new Aviary<>(AviarySize.LARGE);
        aviaryCarnivorous.setSize(AviarySize.MEDIUM);
        aviaryCarnivorous.addAnimal(new Fish("Fish", AviarySize.LARGE));
        aviaryCarnivorous.setSize(AviarySize.MIN);
        aviaryCarnivorous.addAnimal(new Hyena("Hyena", AviarySize.MIN));
        aviaryCarnivorous.addAnimal(new Hawk("Hawk", AviarySize.MIN));


        System.out.println("__________________________________________________");

        System.out.println(aviaryCarnivorous.getAnimal("Hawk").getHunger());
        System.out.println("Animals in aviary: " + aviaryCarnivorous.animalsCount());
        Hawk hawk = new Hawk("Hawk", AviarySize.MIN);
        hawk.setHunger((short)130);
        aviaryCarnivorous.addAnimal(hawk);
        System.out.println(aviaryCarnivorous.getAnimal("Hawk").getHunger());
        System.out.println("Animals count in aviary after trying to add animal with the same name: " + aviaryCarnivorous.animalsCount());
        System.out.println("__________________________________________________");

        try {
            hawk.eat(new Chicken("Meat", (short)15));
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }
        try {
            hawk.eat(new Wheat("Wheat", (short)11));
        } catch (WrongFoodException e) {
            System.out.println(e.getMessage());
        }
    }
}
