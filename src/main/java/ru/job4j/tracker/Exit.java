package ru.job4j.tracker;

public class Exit implements UserAction {
    @Override
    public String name() {
        return "Exit the menu";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Thank you. Goodbye!");
        return false;
    }
}
