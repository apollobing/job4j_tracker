package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1El = o1.split("/");
        String[] o2El = o2.split("/");
        int size = Math.min(o1El.length, o2El.length);
        for (int i = 0; i < size; i++) {
            if (CharSequence.compare(o2El[0], o1El[0]) != 0) {
                return CharSequence.compare(o2El[0], o1El[0]);
            }
            if (CharSequence.compare(o1El[i], o2El[i]) != 0) {
                return CharSequence.compare(o1El[i], o2El[i]);
            }
        }
        return Integer.compare(o1El.length, o2El.length);
    }
}
