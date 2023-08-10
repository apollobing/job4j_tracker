package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        char leftChar = 0;
        char rightChar = 0;
        int size = Math.max(left.length(), right.length());
        for (int i = 0; i < size; i++) {
            if (i < left.length() - 1) {
                leftChar = left.charAt(i);
            } else {
                leftChar = 0;
            }
            if (i < right.length() - 1) {
                rightChar = right.charAt(i);
            } else {
                rightChar = 0;
            }
            if (leftChar != rightChar) {
                break;
            }
        }
        return Character.compare(leftChar, rightChar);
    }
}
