package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ItemTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Road"),
                new Item(2, "Building"),
                new Item(3, "Grass")
        );
        List<Item> expected = Arrays.asList(
                items.get(1),
                items.get(2),
                items.get(0)
        );
        Collections.sort(items, new ItemAscByName());
        assertEquals(items, expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item(1, "Road"),
                new Item(2, "Building"),
                new Item(3, "Grass")
        );
        List<Item> expected = Arrays.asList(
                items.get(0),
                items.get(2),
                items.get(1)
        );
        Collections.sort(items, new ItemDescByName());
        assertEquals(items, expected);
    }
}
