package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        String name = scanner.nextLine();
        int answer = new Random().nextInt(3);
        String rsl = "Может быть";
        if (answer == 0) {
            rsl = "Да";
        } else if (answer == 1) {
            rsl = "Нет";
        }
        System.out.println(rsl);
    }
}
