package org.javase.pojo;

import org.javase.pojo.action.CatAction;

public final class Cat extends Animal{

    private final CatAction move;

    public Cat(String name, CatAction walkingAnimal) {
        super(name);
        this.move = walkingAnimal;
    };

    public CatAction getMove() {
        return move;
    }
}
