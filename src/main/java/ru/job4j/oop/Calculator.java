package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int z) {
        return x - z;
    }

    public int divide(int q) {
        return q / x;
    }

    public int sumAllOperation(int w) {
        return sum(w) + multiply(w) + minus(w) + divide(w);
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(5);
        System.out.println(multiply);
        int minus = Calculator.minus(4);
        System.out.println(minus);
        Calculator calculator2 = new Calculator();
        int divide = calculator2.divide(100);
        System.out.println(divide);
        Calculator calculator3 = new Calculator();
        int sumAllOperation = calculator3.sumAllOperation(4);
        System.out.println(sumAllOperation);
    }
}
