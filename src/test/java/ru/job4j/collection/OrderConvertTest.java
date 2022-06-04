package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrderConvertTest {

    @Test
    public void whenSingleOrder() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("3sfe", "Dress"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.get("3sfe"), is(new Order("3sfe", "Dress")));
    }

    @Test
    public void whenThereAreDuplicates() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order("123", "Petr"));
        orders.add(new Order("234", "Stas"));
        orders.add(new Order("123", "Lena"));
        orders.add(new Order("134", "Petr"));
        orders.add(new Order("234", "Max"));
        HashMap<String, Order> map = OrderConvert.process(orders);
        assertThat(map.size(), is(3));
        assertThat(orders.size(), is(5));
        assertTrue(orders.size() > map.size());
    }
}