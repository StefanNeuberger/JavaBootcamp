package Exercises;

import Calculator.Calculator;

import java.util.Arrays;

public class JavaBasics_6 {
    public static void main(String[] args) {

        // 1.1
        int[] numbers = {1, 2, 3, 4, 5};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // 1.2
        String[] names = {"Hans", "Peter", "Maria", "Lisa"};
        for (String name : names) {
            System.out.println(name);
        }

        // 1.3
        int[] numbers2 = {2, 4, 6, 8};
        for (int number : numbers2) {
            int square = number * number;
            System.out.println(square);
        }

        // 2.1
        int[] numbers3 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < numbers3.length; i++) {
            if (Calculator.isEven(numbers3[i])) {
                System.out.println(numbers3[i]);
            }
        }
        for (int number : numbers3) {
            if (Calculator.isEven(number)) {
                System.out.println(number);
            }
        }

        // 2.2
        int[] numbers4 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = 0;
        for (int j : numbers4) {
            sum += j;
        }
        System.out.println(sum);

        // 2.3
        String[] cities = {"london", "berlin", "paris", "rome"};
        for (int i = 0; i < cities.length; i++) {
            System.out.println(cities[i] + " " + i);
        }

        // 2.4
        int[] numbers5 = {24, 2, 9876, 4, 45, 66, 327, 8, 349, 10};

        int smallest = numbers5[0];
        int biggest = numbers5[0];
        for (int j : numbers5) {
            if (j < smallest) {
                smallest = j;
            }
            if (j > biggest) {
                biggest = j;
            }
        }
        System.out.println("Smallest: " + smallest + " Biggest: " + biggest);

        // 3.1
        int[] numbers6 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < numbers6.length; i++) {
            numbers6[i] = numbers6[i] * 2;
        }

        // 3.2
        String[] firstNames = {"Hans", "Peter", "Maria", "Lisa"};
        String[] lastNames = {"asdf", "sadhf", "asdf", "asdf"};
        String[] fullNames = new String[firstNames.length];

        for (int i = 0; i < fullNames.length; i++) {
            fullNames[i] = firstNames[i] + " " + lastNames[i];
            System.out.println(fullNames[i]);
        }

        // 3.4
        int[] noten = {85, 70, 95, 60};
        int summe = Arrays.stream(noten).sum();
        int average = summe / noten.length;

        int[] test = Arrays.stream(noten).filter(i -> i > 70).toArray();
        System.out.println(Arrays.toString(test));


        // 3.5
        int[] numbers7 = new int[10];
        for (int i = 0; i < numbers7.length; i++) {
            numbers7[i] = (int) (Math.random() * 100);
        }

        Arrays.sort(numbers7);
        System.out.println(Arrays.toString(numbers7));
        int min = Arrays.stream(numbers7).min().getAsInt();
        int max = Arrays.stream(numbers7).max().getAsInt();
        double average2 = Arrays.stream(numbers7).average().orElse(Double.NaN);
        System.out.println("Min: " + min + " Max: " + max + " Average: " + average2);
    }
}
