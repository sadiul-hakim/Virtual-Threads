package org.javase.pojo.action;

public class DogAction implements Action {
    @Override
    public void walk() {
        System.out.println("Dog walk.....");
    }

    @Override
    public void talk() {
        System.out.println("Its bob ghew ghew...");
    }
}
