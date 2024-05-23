package ru.job4j.tracker.store;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.Item;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HbmTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenAddAndReplaceItemThenTrackerHasSameItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item);
            tracker.replace(item.getId(), item2);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item2.getName());
        }
    }

    @Test
    public void whenAddAndDeleteItemThenTrackerHasNotThisItem() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }

    @Test
    public void whenAddItemsThenTrackerHasSameItems() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item2);
            List<Item> result = tracker.findAll();
            assertThat(result).hasSameElementsAs(List.of(item, item2));
        }
    }

    @Test
    public void whenAddNewItemsThenFindTheseItemsInTrackerByName() {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item item2 = new Item();
            item2.setName("test1");
            tracker.add(item2);
            List<Item> result = tracker.findByName("test1");
            assertThat(result).hasSameElementsAs(List.of(item, item2));
        }
    }
}