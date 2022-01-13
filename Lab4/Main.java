import model.animal.Bird;
import model.animal.Lion;
import model.animal.Zebra;
import model.aviary.AviaryBird;
import model.aviary.AviaryLion;
import model.aviary.AviaryMammal;
import model.aviary.AviaryUngulate;
import model.zoo.Zoo;

public class Main {
    public static void main(String[] args) {
        AviaryMammal aviaryMammal = new AviaryMammal(4);
        AviaryUngulate aviaryUngulate = new AviaryUngulate(3);
        AviaryLion aviaryLion = new AviaryLion(2);
        AviaryBird aviaryBird = new AviaryBird(1);
        Lion lion = new Lion();
        Bird bird = new Bird();
        Zebra zebra = new Zebra();
        Zoo zoo = new Zoo();
        zoo.addAviary(aviaryBird);
        zoo.addAviary(aviaryUngulate);
        zoo.addAviary(aviaryLion);
        zoo.addAviary(aviaryMammal);
        System.out.println("Add a lion");
        aviaryMammal.addTarget(lion);
        System.out.println("Add a zebra");
        aviaryUngulate.addTarget(zebra);
        System.out.println("Add a bird");
        aviaryBird.addTarget(bird);
        try {
            System.out.println("Trying to add a bird to mammal's aviary...");
            aviaryMammal.addTarget(new Bird());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }

        try {
            System.out.println("Trying to remove a zebra from mammal's aviary...");
            aviaryMammal.removeTarget(new Zebra());
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
        System.out.println("Remove lion from mammals");
        aviaryMammal.removeTarget(lion);
        System.out.println("Zoo count: " + zoo.getCountOfAnimals());
    }
}
