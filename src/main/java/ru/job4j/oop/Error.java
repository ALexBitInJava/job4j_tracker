package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.message = message;
        this.status = status;
    }

    public void printInfo() {
        System.out.println("Active: " + active);
        System.out.println("Status: " + status);
        System.out.println("Message: " + message);
    }

    public static void main(String[] args) {
        Error error1 = new Error();
        Error error2 = new Error(true, 1, "I am number one");
        Error error3 = new Error(true, 2, " I am number two");
        Error error4 = new Error(false, 0, "I don't have a number");
        error1.printInfo();
        error2.printInfo();
        error3.printInfo();
        error4.printInfo();
    }
}
