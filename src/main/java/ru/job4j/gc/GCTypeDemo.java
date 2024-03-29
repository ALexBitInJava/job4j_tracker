package ru.job4j.gc;

import java.util.Random;

public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (String i : data) {
            i = String.valueOf((char) random.nextInt(255)).repeat(length);
        }
        System.out.println("PID процесса: " + ProcessHandle.current().pid());
    }
}
