package ru.job4j.tracker.action;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindNameTest {
    @Test
    public void whenItemWasFoundByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = tracker.add(new Item("FoundName item"));
        FindName findNameAction = new FindName(output);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(item.getName());

        findNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }

    @Test
    public void whenItemWasNotFoundByNameSuccessfully() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        FindName findNameAction = new FindName(output);

        Input input = mock(Input.class);

        findNameAction.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + input.askStr("") + " не найдены." + ln
        );
    }
}