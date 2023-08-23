package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        Predicate<Person> containsName = person -> person.getName().contains(key);
        Predicate<Person> containsSurname = person -> person.getSurname().contains(key);
        Predicate<Person> containsPhone = person -> person.getPhone().contains(key);
        Predicate<Person> containsAddress = person -> person.getAddress().contains(key);
        Predicate<Person> combine = containsName.or(containsSurname)
                .or(containsPhone).or(containsAddress);
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}