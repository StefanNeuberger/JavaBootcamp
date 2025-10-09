package Exercises;

import Calculator.Calculator;
import InputPrompt.InputPrompt;

import java.util.Scanner;

public class JavaBasics_1 {
    public static void main(String[] args) {

        // initialize the scanner
        // IMPORTANT: Do NOT close this Scanner, as it would close System.in and break subsequent input.
        Scanner scanner = new Scanner(System.in);

        User myUser = new User(InputPrompt.promptString(scanner, "What's your name? "), InputPrompt.promptNonNegativeInt(scanner, "How old are you? "));

        System.out.printf("--------------------------------%n");
        System.out.printf("        New user created        %n" );
        System.out.printf("--------------------------------%n");

        myUser.printUser();

        boolean doSum = InputPrompt.promptYesNo(scanner, "Do you want to sum two numbers? (y/n): ");
        if (doSum) {
            int num3 = InputPrompt.promptInt(scanner, "Enter first number: ");
            int num4 = InputPrompt.promptInt(scanner, "Enter second number: ");
            System.out.println(num3 + "+" + num4 + "=" + Calculator.add(num3, num4));
        }
    }
}
