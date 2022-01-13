package model.aviary;

import model.animal.Animal;
import model.animal.Bird;

import java.util.ArrayList;
import java.util.List;

public class AviaryBird extends Aviary {
    private final Class<Bird> target = Bird.class;
    private List<Bird> birds = new ArrayList<>();

    public AviaryBird(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public Class<Bird> getTarget() {
        return target;
    }

    @Override
    public void addTarget(Animal bird) {
        if (bird.getClass() == getTarget()) {
            if (capacity >= birds.size() + 1) {
                birds.add((Bird) bird);
            } else {
                throw new ArrayIndexOutOfBoundsException("aviary is full");
            }
        } else {
            throw new IllegalArgumentException("bird aviary can contains only bird");
        }
    }

    @Override
    public void removeTarget(Animal animal) {
        if (!birds.contains((Bird) animal)) {
            throw new IllegalArgumentException("bird not found");
        } else {
            birds.remove((Bird) animal);
        }
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getActualCount() {
        return birds.size();
    }
}
