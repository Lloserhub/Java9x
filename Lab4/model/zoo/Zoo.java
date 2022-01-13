package model.zoo;

import model.aviary.Aviary;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    List<Aviary> aviaries = new ArrayList<>();
    public void addAviary(Aviary aviary) {
        aviaries.add(aviary);
    }
    public int getCountOfAnimals() {
        int counter = 0;
        for (Aviary aviary : aviaries) {
            counter += aviary.getActualCount();
        }
        return counter;
    }
}
