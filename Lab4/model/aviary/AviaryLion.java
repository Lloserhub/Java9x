package model.aviary;
import model.animal.Animal;
import model.animal.Bird;
import model.animal.Lion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AviaryLion extends Aviary {
    private final Class<Lion> target = Lion.class;

    List<Lion> lions = new ArrayList<>();

    public AviaryLion(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Class<Lion> getTarget() {
        return target;
    }

    @Override
    public void addTarget(Animal animal) {
        if (animal.getClass() == getTarget()) {
            if (capacity >= lions.size() + 1) {
                lions.add((Lion) lions);
            } else {
                throw new ArrayIndexOutOfBoundsException("aviary is full");
            }
        } else {
            throw new IllegalArgumentException("lion aviary can contains only lion");
        }
    }

    @Override
    public void removeTarget(Animal animal) {
        if (!lions.contains((Lion) animal)) {
            throw new IllegalArgumentException("lion not found");
        } else {
            lions.remove((Lion) animal);
        }
    }


    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getActualCount() {
        return lions.size();
    }
}
