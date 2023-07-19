package ru.job4j.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - drives on roads");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " - stops in bus stations");
    }
}
