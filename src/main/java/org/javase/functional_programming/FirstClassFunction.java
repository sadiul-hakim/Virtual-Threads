package org.javase.functional_programming;

import java.util.function.Function;

/**
 * 1. First-Class Functions
 * Definition:
 * A first-class function is a function that is treated as a first-class citizen in a programming language. This means the function can be:
 * <p>
 * Assigned to a variable
 * Passed as an argument to another function
 * Returned as a result from another function
 * Stored in data structures (e.g., arrays, lists)
 * <p>
 * Essentially, functions are treated like any other object or data type in languages that support first-class functions.
 */

/**
 * 2. Higher-Order Functions
 * Definition:
 * A higher-order function is a function that either:
 *
 * Takes one or more functions as arguments, or
 * Returns a function as a result
 */

public class FirstClassFunction {
    public static void main(String[] args) {
        Function<String, String> func1 = (name) -> "Hello, " + name;
        Function<String, String> func2 = (name) -> "Hey, " + name;
        greet(func1, "Hakim");
        greet(func2, "Hakim");
    }

    public static void greet(Function<String, String> func, String name) {
        System.out.println(func.apply(name));
    }
}
