package org.javase.pojo;

import org.javase.pojo.action.DogAction;

public final class Dog extends Animal {
    private final DogAction dogAction;

    public Dog(String name, DogAction dogAction) {
        super(name);
        this.dogAction = dogAction;
    }

    public DogAction getDogAction() {
        return dogAction;
    }
}
