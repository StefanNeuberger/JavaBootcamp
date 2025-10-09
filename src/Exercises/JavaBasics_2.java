package Exercises;

import InputPrompt.InputPrompt;

import java.util.Scanner;

public class JavaBasics_2 {

    // checks if a given char is a vowel (case-insensitive)
    public static boolean isVowel(char ch) {
        char c = Character.toLowerCase(ch);
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        // Level 1

        String fullName = "Stefan Neuberger";
        byte age = 44;
        float heightInMeters = 1.98F;

        System.out.println("Height: " + heightInMeters + " meters");

        char firstLetterOfName = fullName.charAt(0);
        System.out.println("First Letter of name: " + firstLetterOfName);

        // Level 2

        // 2.1
        String firstName = "Stefan";
        int myAge = 44;
        double myHeight = 1.98;

        System.out.println("My name is " + firstName + ", I am " + myAge + " years old and my height is " + myHeight + " meters.");

        // 2.2
        boolean isAdult = myAge >= 18;

        if (isAdult) {
            System.out.println("The user is an Adult.");
        } else {
            System.out.println("The user is not an Adult.");
        }

        // 2.3
        int num1 = 546;
        int num2 = 56752;

        int sum = num1 + num2;
        int diff = num1 - num2;
        int product = num1 * num2;
        double quotient = (double) num1 / num2;

        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + diff);
        System.out.println(num1 + " x " + num2 + " = " + product);
        System.out.println(num1 + " / " + num2 + " = " + quotient);

        // 2.4

        String sentence = "Dieses Aufgabenblatt testet dein Verständnis zu Integers, Kommazahlen, Boolean, char und String.";
        System.out.println(sentence);
        System.out.println("Length: " + sentence.length());
        System.out.println("First character: " + sentence.charAt(0));
        System.out.println("Uppercase: " + sentence.toUpperCase());

        // Level 3

        // IMPORTANT: Do not use try-with-resources for Scanner(System.in) here.
        // Closing a Scanner created from System.in will also close System.in itself,
        // which would break subsequent input in Exercises.MiniProgram when run from Main.
        Scanner scanner = new Scanner(System.in);

        // 3.1

        String userName = InputPrompt.promptString(scanner, "Please enter your name: ");
        int userAge = InputPrompt.promptNonNegativeInt(scanner, "Please enter your age: ");
        char favoriteLetter = InputPrompt.promptChar(scanner, "Please enter your favorite letter: ");

        System.out.println("Hi " + userName + ", your favorite letter is " + Character.toUpperCase(favoriteLetter) + " and you are " + userAge + " years old.");

        // 3.2

        double double1 = 23.1;
        double double2 = 1.34;

        double sum1 = double1 + double2;
        System.out.println(double1 + " - " + double2 + " = " + sum1);
        if (sum1 > 10) {
            System.out.println("Bigger then 10");
        } else if(sum1 == 10) {
            System.out.println("Equal to 10");
        } else {
            System.out.println("less then 10");
        }

        // 3.3

        char userChar = InputPrompt.promptChar(scanner, "Please enter your favorite letter: ");
        boolean isVowel = isVowel(userChar);
        if (isVowel) {
            System.out.println(userChar + " is a Vowel.");
        } else {
            System.out.println(userChar + " is not a Vowel.");
        }

        // Note: intentionally not closing 'scanner' to keep System.in available for Exercises.MiniProgram

        // 3.4

        MiniProgram.main(args);

    }
}
