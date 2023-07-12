package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    public Item() { }

    public Item(String name) {
        this.name = name;
    }

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public static void main(String[] args) {
        Item item1 = new Item();
        System.out.println(item1.getId() + " " + item1.getName());
        Item item2 = new Item("Simple");
        System.out.println(item2.getId() + " " + item2.getName());
        Item item3 = new Item(11, "Sun");
        System.out.println(item3.getId() + " " + item3.getName());
    }
}