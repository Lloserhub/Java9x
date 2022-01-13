package model.aviary;

import model.animal.Animal;
import model.animal.Bird;
import model.animal.Lion;
import model.animal.Mammal;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AviaryMammal extends Aviary {
    private final Class<Mammal> target = Mammal.class;

    List<Mammal> mammals = new ArrayList<>();

    public AviaryMammal(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Class<Mammal> getTarget() {
        return target;
    }

    @Override
    public void addTarget(Animal animal) {
        if (animal instanceof Mammal) {
            if (capacity >= mammals.size() + 1) {
                mammals.add((Mammal) animal);
            } else {
                throw new ArrayIndexOutOfBoundsException("aviary is full");
            }
        } else {
            throw new IllegalArgumentException("mammals aviary can contains only mammal");
        }
    }

    @Override
    public void removeTarget(Animal animal) {
        if (!mammals.contains((Mammal) animal)) {
            throw new IllegalArgumentException("mammal not found");
        } else {
            mammals.remove((Mammal) animal);
        }
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getActualCount() {
        return mammals.size();
    }
}
