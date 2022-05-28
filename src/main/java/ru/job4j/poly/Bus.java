package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Если? Значит - едем. Пристегнитесь!");
    }

    @Override
    public void passengers(int numOfPas) {
        System.out.println("В автобусе " + numOfPas + " пассажиров.");
    }

    @Override
    public int refuel(int fuelQuantity) {
        return 150;
    }
}
