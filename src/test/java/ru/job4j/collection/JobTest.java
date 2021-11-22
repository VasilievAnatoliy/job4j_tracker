package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorSortByName() {
        Comparator<Job> sort = new JobSortByName();
        int rsl = sort.compare(
                new Job("aaa", 0),
                new Job("bbb", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorSortByPriority() {
        Comparator<Job> sort = new JobSortByPriority();
        int rsl = sort.compare(
                new Job("aaa", 0),
                new Job("bbb", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorDescByName() {
        Comparator<Job> sort = new JobDescByName();
        int rsl = sort.compare(
                new Job("aaa", 0),
                new Job("bbb", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByPriority() {
        Comparator<Job> sort = new JobDescByPriority();
        int rsl = sort.compare(
                new Job("aaa", 0),
                new Job("bbb", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorDescByNameAndDescPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName()
                .thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("aaa", 0),
                new Job("aaa", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenComparatorSortByNameAndSortByPriority() {
        Comparator<Job> cmpNamePriority = new JobSortByName()
                .thenComparing(new JobSortByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("aaa", 0),
                new Job("aaa", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}