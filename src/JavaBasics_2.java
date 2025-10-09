import java.util.Scanner;

public class JavaBasics_2 {
    static String fallbackMessage = "Please enter a non-empty value.";

    // Helper to read a non-empty line of text
    public static String promptString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println(fallbackMessage);
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
        // which would break subsequent input in MiniProgram when run from Main.
        Scanner scanner = new Scanner(System.in);

        // 3.1

        String userName = promptString(scanner, "Please enter your name: ");
        int userAge = promptNonNegativeInt(scanner, "Please enter your age: ");
        char favoriteLetter = promptChar(scanner, "Please enter your favorite letter: ");

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

        char userChar = promptChar(scanner, "Please enter your favorite letter: ");
        boolean isVowel = isVowel(userChar);
        if (isVowel) {
            System.out.println(userChar + " is a Vowel.");
        } else {
            System.out.println(userChar + " is not a Vowel.");
        }

        // Note: intentionally not closing 'scanner' to keep System.in available for MiniProgram

        // 3.4

        MiniProgram.main(args);

    }
}
