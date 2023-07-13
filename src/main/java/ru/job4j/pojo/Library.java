package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Harry Potter", 729);
        Book book2 = new Book("Angels and Demons", 538);
        Book book3 = new Book("Clean code", 1024);
        Book book4 = new Book("Java core", 891);

        Book[] books = new Book[4];
        books[0] = book1;
        books[1] = book2;
        books[2] = book3;
        books[3] = book4;
        for (Book book : books) {
            System.out.println("Book: " + book.getName() + ", pages: "
                    + book.getPages());
        }

        System.out.println("Replace first and last book.");
        books[0] = book4;
        books[3] = book1;
        for (Book book : books) {
            System.out.println("Book: " + book.getName() + ", pages: "
                    + book.getPages());
        }

        System.out.println("Shown only book.name equals Clean code");
        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Book: " + book.getName() + ", pages: "
                        + book.getPages());
            }
        }
    }
}
