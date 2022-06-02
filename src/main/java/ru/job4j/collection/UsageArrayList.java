package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> collection = new ArrayList<>();
        collection.add("Petr");
        collection.add("Stas");
        collection.add("Elena");
        for (String value : collection) {
            System.out.println(value);
        }
    }
}
