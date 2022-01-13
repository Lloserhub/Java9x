package model.aviary;

import model.animal.Animal;
import model.animal.Bird;
import model.animal.Mammal;
import model.animal.Ungulate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AviaryUngulate extends Aviary {
    private final Class<Ungulate> target = Ungulate.class;

    List<Ungulate> ungulates = new ArrayList<>();

    public AviaryUngulate(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Class<? extends Animal> getTarget() {
        return target;
    }

    @Override
    public void addTarget(Animal animal) {
        if (animal instanceof Ungulate) {
            if (capacity >= ungulates.size() + 1) {
                ungulates.add((Ungulate) animal);
            } else {
                throw new ArrayIndexOutOfBoundsException("aviary is full");
            }
        } else {
            throw new IllegalArgumentException("ungulates aviary can contains only ungulate");
        }
    }

    @Override
    public void removeTarget(Animal animal) {
        if (!ungulates.contains((Ungulate) animal)) {
            throw new IllegalArgumentException("bird not found");
        } else {
            ungulates.remove((Ungulate) animal);
        }
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getActualCount() {
        return ungulates.size();
    }
}
