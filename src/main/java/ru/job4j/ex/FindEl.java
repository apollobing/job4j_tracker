package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (i == Integer.parseInt(key)) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] str = {"a", "b", "c"};
        String key = "4";
        try {
            System.out.println(indexOf(str, key));
        } catch (ElementNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}