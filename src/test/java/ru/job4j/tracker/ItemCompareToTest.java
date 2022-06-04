package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemCompareToTest {

    @Test
    public void compareById() {
        List<Item> items = Arrays.asList(new Item(5, "Ben"),
                new Item(2, "Leo"), new Item(4, "Jon"),
                new Item(3, "Max"), new Item(1, "Tom"));
        List<Item> expected = Arrays.asList(new Item(1, "Tom"),
                new Item(2, "Leo"), new Item(3, "Max"),
                new Item(4, "Jon"), new Item(5, "Ben"));
        Collections.sort(items);
        assertThat(items, is(expected));
    }

    @Test
    public void compareDescByName() {
        List<Item> items = Arrays.asList(new Item(5, "Ben"),
                new Item(2, "Leo"), new Item(4, "Jon"),
                new Item(3, "Max"), new Item(1, "Tom"));
        List<Item> expected = Arrays.asList(new Item(1, "Tom"),
                new Item(3, "Max"), new Item(2, "Leo"),
                new Item(4, "Jon"), new Item(5, "Ben"));
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }

    @Test
    public void compareAscByName() {
        List<Item> items = Arrays.asList(new Item(3, "Max"),
                new Item(4, "Tom"), new Item(1, "Jon"),
                new Item(5, "Ben"), new Item(2, "Leo"));
        List<Item> expected = Arrays.asList(new Item(5, "Ben"),
                new Item(1, "Jon"), new Item(2, "Leo"),
                new Item(3, "Max"), new Item(4, "Tom"));
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }
}
