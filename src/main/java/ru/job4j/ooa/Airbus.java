package ru.job4j.ooa;

public final class Airbus extends  Aircraft {
    private static final int COUNT_ENGINE = 2;
    private String name;

    public Airbus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printModel() {
        System.out.println("Модль самолета: " + name);
    }

    public void printCountEngine() {
        int countEngineA380 = name.equals("A380") ? 4 : COUNT_ENGINE;
        System.out.println(countEngineA380);
    }

    @Override
    public String toString() {
        return "Airbus{"
                + "name='" + name + '\''
                + '}';
    }
}
