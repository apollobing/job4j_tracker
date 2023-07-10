package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int a) {
        return a + x;
    }

    public int multiply(int b) {
        return b * x;
    }

    public static int minus(int c) {
        return c - x;
    }

    public int divide(int d) {
        return d / x;
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