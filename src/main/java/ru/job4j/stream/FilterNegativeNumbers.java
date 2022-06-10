package ru.job4j.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, -5, 8, 0, -15, 23, 11, -14, -5);
        List<Integer> positive = new java.util.ArrayList<>(numbers.stream().filter(integer -> integer > 0).toList());
        Collections.sort(positive);
        positive.forEach(System.out::println);
    }
}
