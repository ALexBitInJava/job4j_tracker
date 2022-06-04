package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ItemDescByName implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        return o2.getName().compareTo(o1.getName());
    }

    public static void main(String[] args) {
        List<Item> items = Arrays.asList(new Item(5, "Ben"), new Item(2, "Leo"), new Item(4, "Jon"),
                new Item(3, "Max"), new Item(1, "Tom"));
        Collections.sort(items, new ItemDescByName());
        System.out.println(items);
        Collections.sort(items, new ItemAscByName());
        System.out.println(items);
    }
}
