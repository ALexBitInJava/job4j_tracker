package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void whenMethodThrowsAnException() {
        Fact.calc(-4);
    }

    @Test
    public void calc() {
        int rsl = Fact.calc(4);
        assertThat(rsl, is(24));
    }
}