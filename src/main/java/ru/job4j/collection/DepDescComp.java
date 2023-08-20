package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1El = o1.split("/");
        String[] o2El = o2.split("/");
        int result = o2El[0].compareTo(o1El[0]);
        return result != 0 ? result : o1.compareTo(o2);
    }
}
