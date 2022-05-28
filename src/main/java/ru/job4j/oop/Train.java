package ru.job4j.oop;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(nameClass() + " передвигается по рельсам.");
    }

    @Override
    public String nameClass() {
        return "Поезд";
    }
}
