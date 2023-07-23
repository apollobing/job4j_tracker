package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(6);
    }

    @Test
    public void whenValidMultiInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "1", "6"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int first = input.askInt("Enter menu:");
        assertThat(first).isEqualTo(1);
        int second = input.askInt("Enter menu:");
        assertThat(second).isEqualTo(1);
        int third = input.askInt("Enter menu:");
        assertThat(third).isEqualTo(6);
    }

    @Test
    public void whenMinusInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"-2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected).isEqualTo(-2);
    }
}