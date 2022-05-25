package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setfNLNP("Alex Golovin Igorevich");
        student.setGroup("Java developer in 6 months");
        LocalDateTime receipt = LocalDateTime.of(2022, 05, 13, 20, 42);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy в HH: mm");
        student.setReceiptDate(receipt.format(formatter));
        System.out.println("ФИО студента: " + student.getfNLNP() + ", группа: " + student.getGroup()
                + ", дата поступления: " + student.getReceiptDate());
    }
}
