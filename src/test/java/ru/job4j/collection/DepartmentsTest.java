package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedK2() {
        List<String> input = List.of("k2/sk1");
        List<String> expect = List.of("k2", "k2/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenMissedK2AndK2SK1() {
        List<String> input = List.of("k2/sk1/ssk2");
        List<String> expect = List.of("k2", "k2/sk1", "k2/sk1/ssk2");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }
}