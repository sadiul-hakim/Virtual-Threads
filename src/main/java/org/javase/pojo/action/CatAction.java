package org.javase.pojo.action;

public final class CatAction implements Action {
    @Override
    public void walk() {
        System.out.println("Mew Mew....");
    }

    @Override
    public void talk() {
        System.out.println("Cat walk....");
    }
}
