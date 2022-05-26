package ru.job4j.tracker;

import java.util.Objects;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item name = items[i];
            if (Objects.equals(name.getName(), key)) {
                rsl[size] = name;
                size++;
            }
        }
        return rsl;
    }

    public int findById(int id) {
        int rsl = 0;
        for (int i = 0; i < items.length; i++) {
            Item byId = items[i];
            if (byId.getId() != id) {
                return 0;
        }
        return id;
    }
}