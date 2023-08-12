package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет модель банковского счета
 * @author apollobing
 * @version 1.0
 */
public class Account {
    /**
     * Поле содержит реквизиты
     */
    private String requisite;
    /**
     * Поле содержит баланс
     */
    private double balance;

    /**
     * При создании объекта Account конструктор инициализирует поля
     * @param requisite для инициализации поля requisite
     * @param balance для инициализации поля balance
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты
     * @return значение поля requisite
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод позволяет присвоить реквизиты
     * @param requisite строка содержащая реквизиты
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс
     * @return значение поля balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод позволяет присвоить баланс
     * @param balance число содержащее баланс
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод equals переопределяется для сравнения объектов Account по полю requisite
     * @param o объект с которым происходит сравнение
     * @return возвращает true или false
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод hashCode переопределяется для сравнения объектов Account по полю requisite
     * @return возвращает значение типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
