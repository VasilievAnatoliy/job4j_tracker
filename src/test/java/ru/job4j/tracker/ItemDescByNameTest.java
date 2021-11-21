package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ItemDescByNameTest {

    @Test
    public void compare() {
        Item a = new Item("aaaa");
        Item ab = new Item("aabb");
        Item b = new Item("bbbb");
        Item c = new Item("cccc");
        List<Item> items = Arrays.asList(ab, c, a, b);
        List<Item> expected = Arrays.asList(c, b, ab, a);
        Collections.sort(items, new ItemDescByName());
        assertThat(items, is(expected));
    }
}