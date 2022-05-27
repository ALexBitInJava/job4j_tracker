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
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int search = indexOf(id);
        if (search != -1) {
            items[search].setName(item.getName());
            return true;
        } else {
            return false;
        }
    }
}