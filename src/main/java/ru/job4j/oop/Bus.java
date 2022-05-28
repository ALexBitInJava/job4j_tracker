package ru.job4j.oop;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(nameClass() + " двигается по скоростным трассам.");
    }

    @Override
    public String nameClass() {
        return "Автобус";
    }
}
