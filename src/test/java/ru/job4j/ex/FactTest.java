package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenHasNotException() {
        int expected = 120;
        int result = new Fact().calc(5);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Fact().calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }
}
