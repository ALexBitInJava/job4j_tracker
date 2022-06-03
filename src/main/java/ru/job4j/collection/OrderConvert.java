package ru.job4j.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderConvert {
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order o : orders) {
            map.put(o.getNumber(), o);
        }
        return map;
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("123", "Petr"));
        orders.add(new Order("234", "Stas"));
        orders.add(new Order("123", "Lena"));
        orders.add(new Order("134", "Petr"));
        orders.add(new Order("234", "Max"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        for (Map.Entry<String, Order> entry : map.entrySet()) {
            Order ord = entry.getValue();
            System.out.println(ord);
        }
        if (orders.size() > map.size()) {
            System.out.println("Всё работает правильно. Размер map = " + map.size());
        } else {
            System.out.println("Где - то ошибка");
        }
    }
}
