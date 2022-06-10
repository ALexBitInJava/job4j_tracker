package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class CustomNameTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        CustomName function = new CustomName();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11.0, 13.0, 15.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        CustomName function = new CustomName();
        List<Double> result = function.diapason(4, 7, x -> 2 * Math.pow(x, 2) + x + 1);
        List<Double> expected = Arrays.asList(37.0, 56.0, 79.0);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResults() {
        CustomName function = new CustomName();
        List<Double> result = function.diapason(4, 7, x -> Math.pow(2, x));
        List<Double> expected = Arrays.asList(16.0, 32.0, 64.0);
        assertThat(result, is(expected));
    }

}