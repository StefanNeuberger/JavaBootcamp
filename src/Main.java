import java.util.Scanner;

public class Main {

    public void printText(String[] array) {
        for (String s : array) {
            System.out.println(s);
            System.out.println();
        }
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        String[] outputs = {"Hello World", "How are you?", "This is a test."};

        // non static methods can only be called by creating an instance of the class it belongs to
        // create instance of class
        Main myInstance = new Main();
        myInstance.printText(outputs);

        int num1 = 2;
        int num2 = 15;

        // static methods are called using the class name
        int result = Main.sum(num1, num2);
        System.out.println(num1 + "+" + num2 + "=" + result);

        // initialize the scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("Whats you name? ");
        String userName = scanner.next();
        System.out.println("How old are you? ");
        int age = scanner.nextInt();

        System.out.printf("--------------------------------%n");
        System.out.printf("| %-10s | %-8s |%n", "NAME", "AGE");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-10s | %-8s |%n", userName, age);
        System.out.printf("--------------------------------%n");

        System.out.println("Do you want to summarize two numbers? : y / n");
        char decision = scanner.next().charAt(0);

        switch (decision) {
            case 'y':
                System.out.println("Enter first number: ");
                int num3 = scanner.nextInt();
                System.out.println("Enter second number: ");
                int num4 = scanner.nextInt();
                System.out.println(num3 + "+" + num4 + "=" + Main.sum(num3, num4));
                break;
            case 'n':
                break;
            default:
                 System.out.println("Invalid input");
        }


    }
}

