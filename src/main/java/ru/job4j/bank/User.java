package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс представляет модель пользователя банка
 * @author apollobing
 * @version 1.0
 */
public class User {
    /**
     * Поле содержит номер паспорта
     */
    private String passport;
    /**
     * Поле содержит ФИО
     */
    private String username;

    /**
     * При создании объекта User конструктор инициализирует поля
     * @param passport для инициализации поля passport
     * @param username для инициализации поля username
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Метод позволяет получить номер паспорта
     * @return значение поля passport
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Метод позволяет присвоить номер паспорта
     * @param passport строка содержащая номер паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Метод позволяет получить ФИО
     * @return значение поля username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Метод позволяет присвоить ФИО
     * @param username строка содержащая ФИО
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Метод equals переопределяется для сравнения объектов User по полю passport
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
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Метод hashCode переопределяется для сравнения объектов User по полю passport
     * @return возвращает значение типа int
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
