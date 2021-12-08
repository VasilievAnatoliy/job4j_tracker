package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MatrixTest {

    @Test
    public void whenMatrixToList() {
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8}
        };
        Matrix mat = new Matrix();
        List<Integer> rsl = mat.flatMap(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(rsl, is(expected));
    }
}