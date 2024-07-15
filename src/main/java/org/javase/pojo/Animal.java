package org.javase.pojo;

public abstract sealed class Animal permits Cat, Dog {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
