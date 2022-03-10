package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader().
                getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenAdd() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        tracker.add(new Item("Third"));
        assertThat(tracker.findAll().size(), is(3));
    }

    @Test
    public void whenReplace() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = new Item("Second");
        assertTrue(tracker.replace(first.getId(), second));
        assertThat(tracker.findById(first.getId()).getName(), is(second.getName()));
    }

    @Test
    public void whenDeleteItem() {
        SqlTracker tracker = new SqlTracker(connection);
        tracker.add(new Item("First"));
        tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        assertThat(tracker.findAll().size(), is(3));
        assertTrue(tracker.delete(third.getId()));
        assertThat(tracker.findAll().size(), is(2));
    }

    @Test
    public void whenFindAll() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        assertThat(tracker.findAll(), is(List.of(first, second, third)));
    }

    @Test
    public void whenFindByName() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first1 = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item first2 = tracker.add(new Item("First"));
        assertThat(tracker.findByName(first1.getName()), is(List.of(first1, first2)));
    }

    @Test
    public void whenFindById() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = tracker.add(new Item("First"));
        Item second = tracker.add(new Item("Second"));
        Item third = tracker.add(new Item("Third"));
        assertThat(tracker.findById(second.getId()), is(second));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }
}