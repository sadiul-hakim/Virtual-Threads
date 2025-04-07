package org.javase.functional_programming;

public class LexicalScopingExample {
    public static void main(String[] args) {
        outer();
    }

    public static void outer() {
        String outerVar = "I am outer";
        Runnable inner = () -> System.out.println(outerVar); // Access outerVar
        inner.run();
    }
}
