package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest extends TestCase {

    @Test
    public void testDistance() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(4, 0.001));
    }

    @Test
    public void testDistance1() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 5);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(5, 0.001));
    }
}

