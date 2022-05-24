package ru.job4j.oop;

public class Cat {
    public static void main(String[] args) {
        Cat petty = new Cat();
        String say = petty.name();
        System.out.println("Petty says " + say);
    }

    public String name() {
        String voice = "may-may";
        return  voice;
    }
}
