package Exercises;

import Calculator.Calculator;

public class JavaBasics_5 {
    static void printHello() {
        System.out.println("Hello World!");
    }

    static String getGreeting() {
        return "Willkommen im Java Kurs";
    }

    static void printName(String name) {
        System.out.println("Hallo " + name);
    }


    static double calcutaleArea(double width, double height) {
        return width * height;
    }

    static void checkPositive(int number) {
        if (number < 0) {
            System.out.println("Negative Number");
        }
    }

    static void printSumMessage(int a, int b) {
        int sum = Calculator.add(a, b);
        System.out.println("Summe: " + sum);
    }

    public static void main(String[] args) {

        // 1.1
        printHello();

        // 1.2
        System.out.println(getGreeting());

        // 1.3
        printName("Hans");

        // 2.1
        int sum = Calculator.add(1, 2);
        System.out.println("Summe: " + sum);

        // 2.2
        double area = calcutaleArea(10.24, 20.4);
        System.out.println("area: " + area);

        // 2.3
        checkPositive(2);

        // 3.1
        System.out.println(Calculator.isEven(2));
        System.out.println(Calculator.isEven(3));

        // 3.2
        printSumMessage(1, 2);

        // 3.3
        int sum1 = Calculator.add(1, 2);
        int sum3 = Calculator.subtract(10, 5);
        int sum4 = Calculator.multiply(10, 5);
        double sum5 = Double.NaN; // Use NaN as a sentinel for "not successfully initialized"
        try {
            sum5 = Calculator.divide(10, 3);
        } catch (ArithmeticException e) {
            System.out.println("Error while dividing: " + e.getMessage());
        }
        // Check whether sum5 was successfully initialized (i.e., division succeeded)
        if (!Double.isNaN(sum5)) {
            System.out.println("division result: " + sum5);
        }

    }
}
