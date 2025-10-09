package Exercises;

import java.util.Scanner;

public class JavaBasics_3 {

    // Helper to get a yes/no answer
    public static boolean promptYesNo(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String ans = scanner.nextLine().trim().toLowerCase();
            if (ans.equals("y") || ans.equals("yes")) return true;
            if (ans.equals("n") || ans.equals("no")) return false;
            System.out.println("Please answer with 'y' or 'n'.");
        }
    }

    static boolean isEvenAndGreaterThanFifty(int number) {
        return number % 2 == 0 && number > 50;
    }

    public static void main(String[] args) {

        // 1.1

        int num1 = 12;
        int num2 = 10;
        int result = num1 + num2;
        System.out.println("Result: " + result);

        // 1.2

        System.out.println(num1 == num2 ? "Equal" : "Not Equal");

        // 1.3

        System.out.println(num1 > 0 && num1 < 100);

        // 2.1

        int rest = num1 % num2;
        System.out.println("Rest: " + rest);
        System.out.println("Rest is 0?" + (rest == 0));

        System.out.println("Rest is positive?" + ((rest != 0 )&&(rest > 0)));

        // 2.2

        double price = 22.2;
        boolean discountAvailable = true;
        int discount = 10;

        double finalPrice = !discountAvailable ? price : price - (price * discount / 100);
        System.out.println("Final Price: " + finalPrice);

        // 2.3

        System.out.println(num1 + " is even and greater than 50? " + isEvenAndGreaterThanFifty(num1));

        // 3.1

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int userNumber = scanner.nextInt();
        System.out.println((userNumber > 10 && userNumber < 20) ? "Treffer" : "kein Treffer");


        // 3.2

        int a = 10;
        int b = 2;
        int c = -3;

        if((a>b) && ((b<c) || (c<0))) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        // 3.3

        System.out.println("how old are you?");
        int age = scanner.nextInt();
        boolean member = promptYesNo(scanner, "Are you a member? ");

        if(age >= 18 && member) {
            System.out.println("You can enter!");
        } else {
            System.out.println("Sorry, you can't enter!");
        }

    }
}
