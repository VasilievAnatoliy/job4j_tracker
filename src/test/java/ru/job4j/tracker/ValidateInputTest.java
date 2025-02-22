package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"3"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(3));

    }

    @Test
    public void whenALotOfValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"3", "1", "4", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int three = input.askInt("Enter menu:");
        int one = input.askInt("Enter menu:");
        int four = input.askInt("Enter menu:");
        int two = input.askInt("Enter menu:");
        String ln = System.lineSeparator();
        assertThat(three, is(3));
        assertThat(one, is(1));
        assertThat(four, is(4));
        assertThat(two, is(2));
    }

    @Test
    public void whenNegativeInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        String ln = System.lineSeparator();
        assertThat(selected, is(-2));
    }
}