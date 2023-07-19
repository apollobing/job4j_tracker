package ru.job4j.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - drives on railroad tracks");
    }

    @Override
    public void stop() {
        System.out.println(getClass().getSimpleName() + " - stops in railway stations");
    }
}
