package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ItemAscByNameTest {

    @Test
    public void compare() {
        Item a = new Item("aaaa");
        Item ab = new Item("aabb");
        Item b = new Item("bbbb");
        Item c = new Item("cccc");
        List<Item> items = Arrays.asList(c, b, a, ab);
        List<Item> expected = Arrays.asList(a, ab, b, c);
        Collections.sort(items, new ItemAscByName());
        assertThat(items, is(expected));
    }
}