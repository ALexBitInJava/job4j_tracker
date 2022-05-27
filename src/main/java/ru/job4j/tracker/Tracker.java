package ru.job4j.tracker;

import java.util.Arrays;

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

    public Item[] findAll() {
        Item[] array = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            if (item != null) {
                array[size] = item;
                size++;
            }
        }
        array = Arrays.copyOf(array, size);
        return array;
    }

    public Item[] findByName(String key) {
        Item[] array = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
                array[i] = items[i];
                if (array[i] != null && key.equals(array[i].getName())) {
                    array[i].setName(key);
                    size++;
                }
        }
        array = Arrays.copyOf(array, size);
        return array;
    }
}