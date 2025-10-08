import java.util.Scanner;
public class Main {

    // Prints each string on its own line (no extra blank lines)
    public void printText(String[] array) {
        for (String s : array) {
            System.out.println(s);
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    // Helper to read a non-empty line of text
    public static String promptString(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            if (!line.isEmpty()) {
                return line;
            }
            System.out.println("Please enter a non-empty value.");
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

    public static void main(String[] args) {
        String[] outputs = {"Hello World", "How are you?", "This is a test."};

        // non-static methods can only be called by creating an instance of the class it belongs to
        // create instance of class
        Main myInstance = new Main();
        myInstance.printText(outputs);

        // initialize the scanner
        // try-with-resources syntax -> automatically closes the resource
        try (Scanner scanner = new Scanner(System.in)) {

            User myUser = new User(promptString(scanner, "What's your name? "), promptNonNegativeInt(scanner, "How old are you? "));

            System.out.printf("--------------------------------%n");
            System.out.printf("        New user created        %n" );
            System.out.printf("--------------------------------%n");

            myUser.printUser();

            boolean doSum = promptYesNo(scanner, "Do you want to sum two numbers? (y/n): ");
            if (doSum) {
                int num3 = promptInt(scanner, "Enter first number: ");
                int num4 = promptInt(scanner, "Enter second number: ");
                System.out.println(num3 + "+" + num4 + "=" + Main.sum(num3, num4));
            }
        }
    }
}

