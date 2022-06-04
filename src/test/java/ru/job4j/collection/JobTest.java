package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.*;

public class JobTest {

    @Test
    public void whenComparatorDescByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(new Job("Impl task", 0), new Job("Fix bug", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByNameAndPriority() {
        Comparator<Job> ascByNameAndPriority = new JobAscByName().thenComparing(new JobAscByPriority());
        int rsl = ascByNameAndPriority.compare(new Job("Number1", 0), new Job("Number2", 1));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorEqualByPriorityAndDescName() {
        Comparator<Job> equalByPriorityAndDescName = new JobAscByPriority().thenComparing(new JobDescByName());
        int rsl = equalByPriorityAndDescName.compare(new Job("Number1", 0), new Job("Number2", 0));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorEqualByPriorityAndAscName() {
        Comparator<Job> equalByPriorityAndDescName = new JobAscByPriority().thenComparing(new JobAscByName());
        int rsl = equalByPriorityAndDescName.compare(new Job("Number1", 0), new Job("Number2", 0));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorEqualByNameAscByPriority() {
        Comparator<Job> equalByNameAndPriority = new JobDescByName().thenComparing(new JobAscByPriority());
        int rsl = equalByNameAndPriority.compare(new Job("Number1", 11), new Job("Number1", 10));
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorEqualByNameDescByPriority() {
        Comparator<Job> equalByNameAndPriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = equalByNameAndPriority.compare(new Job("Number1", 11), new Job("Number1", 10));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        Comparator<Job> jobsAscName = new JobAscByName();
        int rsl = jobsAscName.compare(new Job("Number1", 01),
                new Job("Number2", 11));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> jobsDescName = new JobAscByName();
        int rsl = jobsDescName.compare(new Job("Number1", 11),
                new Job("Number2", 01));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByPriority() {
        Comparator<Job> jobsAscPriority = new JobAscByPriority();
        int rsl = jobsAscPriority.compare(new Job("Number1", 01),
                new Job("Number2", 11));
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> jobsDescPriority = new JobAscByPriority();
        int rsl = jobsDescPriority.compare(new Job("Number1", 11),
                new Job("Number2", 01));
        assertThat(rsl, greaterThan(0));
    }
}