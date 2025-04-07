package org.javase.species;

public class Animal {
    private String name;
    private int age;
    private String color;
    private String species;

    public Animal() {

    }

    public Animal(String n) {
        name = n;
    }

    public Animal(String n, int a) {
        name = n;
        age = a;
    }

    public Animal(String n, int a, String c) {
        name = n;
        age = a;
        color = c;
    }

    public Animal(String n, int a, String c,String s) {
        name = n;
        age = a;
        color = c;
        species = s;
    }

    public String getName(){
        return makeUppercase();
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public String getSpecies() {
        return species;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    private String makeUppercase(){
        return name.toUpperCase();
    }
}
