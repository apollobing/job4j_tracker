package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.Validate;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.Stub;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateTest {

    @Test
    public void whenInvalidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"one", "1"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"6"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"1", "1", "6"}
        );
        Validate input = new Validate(out, in);
        int first = input.askInt("Enter menu:");
        assertThat(first).isEqualTo(1);
        int second = input.askInt("Enter menu:");
        assertThat(second).isEqualTo(1);
        int third = input.askInt("Enter menu:");
        assertThat(third).isEqualTo(6);
    }

    @Test
    public void whenMinusInput() {
        Output out = new Stub();
        Input in = new ru.job4j.tracker.input.Stub(
                new String[] {"-2"}
        );
        Validate input = new Validate(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }
}