package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSerchTest {

    @Test
    public void exctraNumber() {
        List<Task> tasks = Arrays.asList(new Task("1", "First desc"),
                new Task("2", "Two desc"),
                new Task("1", "First desc"));
        Set<String> expected = new HashSet<>(Arrays.asList("1", "2"));
        assertThat(FullSerch.exctraNumber(tasks), is(expected));
    }

}