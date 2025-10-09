package Exercises;

import InputPrompt.InputPrompt;

import java.util.Scanner;

public class MiniProgram {

    public static void main(String[] args) {
        // IMPORTANT: Do NOT close this Scanner, as it would close System.in for the rest of the app.
        Scanner scanner = new Scanner(System.in);
        int num3 = InputPrompt.promptInt(scanner, "first integer: ");
        int num4 = InputPrompt.promptInt(scanner, "second integer: ");
        double num5 = InputPrompt.promptDouble(scanner, "double: ");

        double sum = num3 + num4 + num5;

        System.out.println(num3 + " + " + num4 + " + " + num5 + " = " + sum);

        if(sum > 0) {
            System.out.println(sum + " is a positive integer.");
        } else if (sum == 0) {
            System.out.println(sum + " is neutral");
        } else {
            System.out.println(sum + " is not a positive integer.");
        }
    }
}
