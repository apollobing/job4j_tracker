package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return x + a;
    }

    public int multiply(int b) {
        return x * b;
    }

    public static int minus(int c) {
        return x - c;
    }

    public int divide(int d) {
        return x / d;
    }

    public int sumAllOperation(int e) {
        return sum(e) + multiply(e) + minus(e) + divide(e);
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println(sum(10));
        System.out.println(calculator.multiply(5));
        System.out.println(minus(3));
        System.out.println(calculator.divide(1));
        System.out.println(calculator.sumAllOperation(7));
    }
}