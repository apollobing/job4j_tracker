package ru.job4j.cast;

public class Airplane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - flights in the sky");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " - stops in airports");
    }
}
