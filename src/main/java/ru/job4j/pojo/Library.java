package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book oneBook = new Book("Clean code", 222);
        Book twoBook = new Book("Grokking Algorithms", 333);
        Book threeBook = new Book("Thinking Java", 777);
        Book fourBook = new Book("The Philosophy of Java", 1333);
        Book[] arrayBooks = new Book[4];
        arrayBooks[0] = oneBook;
        arrayBooks[1] = twoBook;
        arrayBooks[2] = threeBook;
        arrayBooks[3] = fourBook;
        for (int i = 0; i < arrayBooks.length; i++) {
            Book book = arrayBooks[i];
            System.out.println("The book: " + book.getName() + " and pages in it: " + book.getNumberOfPages());
        }
        Book rearrange = arrayBooks[0];
        arrayBooks[0] = arrayBooks[3];
        arrayBooks[3] = rearrange;
        for (int i = 0; i < arrayBooks.length; i++) {
            Book book = arrayBooks[i];
            if ("Clean code".equals(book.getName())) {
                System.out.println("The book you were looking for: " + book.getName() + " and pages in it: " + book.getNumberOfPages());
            }
        }
    }
}
