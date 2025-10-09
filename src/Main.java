import Calculator.Calculator;
import InputPrompt.InputPrompt;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        String[] outputs = {"Hello World", "How are you?", "This is a test."};

        // initialize the scanner
        // try-with-resources syntax -> automatically closes the resource
        try (Scanner scanner = new Scanner(System.in)) {

            User myUser = new User(InputPrompt.promptString(scanner, "What's your name? "), InputPrompt.promptNonNegativeInt(scanner, "How old are you? "));

            System.out.printf("--------------------------------%n");
            System.out.printf("        New user created        %n" );
            System.out.printf("--------------------------------%n");

            myUser.printUser();

            boolean doSum = InputPrompt.promptYesNo(scanner, "Do you want to sum two numbers? (y/n): ");
            if (doSum) {
                int num3 = InputPrompt.promptInt(scanner, "Enter first number: ");
                int num4 = InputPrompt.promptInt(scanner, "Enter second number: ");
                System.out.println(num3 + "+" + num4 + "=" + Calculator.sum(num3, num4));
            }
        }
    }
}

