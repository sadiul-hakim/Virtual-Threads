package org.javase.virtualThreadCourse;

public class Main {
    public static void main(String[] args) {
        String key = "[0]";
        if (key.matches("\\[(\\d+)]")) {

            System.out.println(Integer.parseInt(key.replace("[", "").replace("]", "")));
        }
    }
}
