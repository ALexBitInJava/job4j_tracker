package ru.job4j.oop;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(nameClass() + " летает по воздуху.");
    }

    @Override
    public String nameClass() {
        return "Самолёт";
    }
}
