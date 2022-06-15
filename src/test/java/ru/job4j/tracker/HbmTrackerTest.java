package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class HbmTrackerTest {
    @Test
    public void whenAddAndFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("name", "description");
        tracker.add(item);
        List<Item> all = tracker.findAll();
        assertEquals(item, all.get(0));
    }

    @Test
    public void whenFindAll() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        tracker.add(item1);
        tracker.add(item2);
        assertEquals(List.of(item1, item2), tracker.findAll());
    }

    @Test
    public void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        tracker.add(item1);
        item2 = tracker.add(item2);
        assertTrue(tracker.delete(item2.getId()));
        assertEquals(List.of(item1), tracker.findAll());
    }

    @Test
    public void whenReplace() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        item1 = tracker.add(item1);
        assertTrue(tracker.replace(item1.getId(), item2));
        tracker.replace(item1.getId(), item2);
    }

    @Test
    public void whenFindByName() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        tracker.add(item1);
        tracker.add(item2);
        assertEquals(tracker.findByName("name2"), List.of(item2));
    }

    @Test
    public void whenFindById() {
        HbmTracker tracker = new HbmTracker();
        Item item1 = new Item("name1", "description1");
        Item item2 = new Item("name2", "description2");
        item1 = tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findById(item1.getId()), is(item1));
    }
}