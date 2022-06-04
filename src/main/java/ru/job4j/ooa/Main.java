package ru.job4j.ooa;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        final User FIRST_USER = new User("Petr", 32);
        System.out.println("Вывод в консоль до изменени.");
        System.out.println(FIRST_USER);

        FIRST_USER.setName("Petr Arsentev");
        FIRST_USER.setAge(33);
        System.out.println("Вывод в консоль после изменени.");
        System.out.println(FIRST_USER);
    }

    public static boolean addNewElement(List<String> list, int index, String str) {
        List<String> check = new ArrayList<>(list);
        check.add(index, str);
        return list.size() < check.size();
    }
}
