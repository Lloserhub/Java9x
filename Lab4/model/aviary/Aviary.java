package model.aviary;
import model.animal.Animal;

public abstract class Aviary {
    protected Class<Animal> target;

    protected int capacity;

    protected abstract Class<? extends Animal> getTarget();

    public abstract void addTarget(Animal animal);

    public abstract void removeTarget(Animal animal);

    public abstract int getCapacity();

    public abstract int getActualCount();
}
