package ru.job4j.oop;

public class Cat {
    private String name;
    private String food;

    public void giveNick(String nick) {
        this.name = nick;
    }

    public void show() {
        System.out.println("Cat " + this.name + " ate " + this.food);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public static void main(String[] args) {
        Cat peppy = new Cat();
        Cat sparky = new Cat();
        peppy.giveNick("Pep");
        peppy.eat("Milk");
        peppy.show();
        sparky.giveNick("Spar");
        sparky.eat("Popcorn");
        sparky.show();
    }
}
