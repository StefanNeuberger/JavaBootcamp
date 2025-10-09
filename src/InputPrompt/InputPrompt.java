package InputPrompt;

import java.util.Scanner;

public class InputPrompt {

    static String fallbackMessage = "Please enter a non-empty value.";

    // Helper to read a non-empty line of text
    public static String promptString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                // If input stream is closed or no full line is available, avoid throwing and return empty string
                System.out.println("No input available. Using empty string.");
                return "";
            }
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println(fallbackMessage);
        }
    }

    // Helper to read a double with validation
    public static double promptDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!scanner.hasNextLine()) {
                // No complete line available; wait for more input in the loop
                continue;
            }
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("That's not a valid double. Try again.");
            }
        }
    }

    // Helper to read a single alphabetical letter (A-Z)
    public static char promptChar(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();

            if (line.isEmpty()) {
                System.out.println(fallbackMessage);
                continue;
            }

            if (line.length() == 1) {
                char ch = line.charAt(0);
                if (Character.isLetter(ch)) {
                    return ch;
                } else {
                    System.out.println("Please enter a letter (A-Z). No digits or symbols.");
                    continue;
                }
            }

            // If multiple characters were entered, enforce exactly one letter
            System.out.println("Please enter exactly one letter (A-Z).");
        }
    }

    // Helper to read an int with validation
    public static int promptInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); // consume the rest of the line
                return value;
            } else {
                System.out.println("That's not a valid integer. Try again.");
                scanner.nextLine(); // discard invalid input
            }
        }
    }

    // Helper to read a non-negative int (e.g., for age)
    public static int promptNonNegativeInt(Scanner scanner, String prompt) {
        while (true) {
            int value = promptInt(scanner, prompt);
            if (value >= 0) {
                return value;
            }
            System.out.println("Please enter a non-negative integer.");
        }
    }


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
}
