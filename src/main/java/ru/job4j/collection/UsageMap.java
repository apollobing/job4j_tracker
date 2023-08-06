package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> users = new HashMap<>();
        users.put("one@email.com", "Petr");
        users.put("two@email.com", "Stas");
        users.put("one@email.com", "Tim");
        users.put("two@email.com", "Bob");
        for (String key : users.keySet()) {
            String value = users.get(key);
            System.out.println("email: " + key + ", name: " + value);
        }
    }
}
