package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("John Smith");
        student.setStudyGroup("IT");
        student.setReceiptDate(new Date());

        System.out.println("Student: " + student.getFullName()
                + ", study group: " + student.getStudyGroup()
                + ", receipt date: " + student.getReceiptDate());
    }
}
