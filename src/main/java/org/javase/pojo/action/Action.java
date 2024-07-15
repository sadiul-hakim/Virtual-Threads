package org.javase.pojo.action;

public interface Action {
    String HI = "HI";// public static final

    void walk();

    void talk();

    default void heartBeat(){
        System.out.println(HI);
        System.out.println("--__--_---__--_-__---__-_____------");
    }

    static void dance(){
        System.out.println("Dancing..... tew tew");
    }
}
