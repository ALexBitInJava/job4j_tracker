package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item item = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String itemFormat = item.getDateTime().format(formatter);
        System.out.println("Дата и время по заданию: " + itemFormat);

        Item item1 = new Item();
        System.out.println(item1);
    }
}
