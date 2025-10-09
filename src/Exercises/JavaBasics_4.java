package Exercises;

import java.util.Scanner;

public class JavaBasics_4 {

    static void register(String username, int age) {
        if( username == null || username.trim().isEmpty() || age < 18) {
            return;
        }
        System.out.println("Registrierung erfolgreich");
    }

    public static void main(String[] args) {


        // 1.1
        int age = 44;
        if(age>=18) {
            System.out.println( "Volljährig");
        }

        // 1.2
        boolean isRaining = true;
        if(isRaining) {
            System.out.println("Nimm einen Regenschirm");
        } else {
            System.out.println("Kein Regenschirm nötig");
        }

        // 1.3
        String city = "Hamburg";
        if(city.equals("Berlin"))  {
            System.out.println("Hauptstadt");
        }

        // 2.1
        int score = 2;
        boolean hasTicket = false;
        int minimumScore = 50;
        boolean canEnter = score >= minimumScore && hasTicket;
        if(canEnter) {
            System.out.println("Du kannst eintreten");
        } else {
            System.out.println("Du darfst eintreten");
        }

        // 2.2
        int temp = 33;
        String tempFeeling;
        if(temp >= 30) {
            tempFeeling = "Heiß";
        } else if (temp >= 20) {
            tempFeeling = "Warm";
        } else if (temp >= 10) {
            tempFeeling = "Kühl";
        } else {
            tempFeeling = "Kalt";
        }

        // 2.3
        int number = 345;
        boolean parity = (((number % 2) == 0 ) && (number > 0)) ? true : false;
        System.out.println(parity ? "gerade" : "ungerade");

        // 3
        try(Scanner scanner = new Scanner(System.in)) {

            // 3.1
            System.out.println("Your name: ");
            String name = scanner.nextLine();
            while(name.trim().isEmpty()) {
                System.out.println("Name darf nicht leer sein");
                name = scanner.nextLine();
            }
            System.out.println("Hello " + name);

            // 3.2
            double x = 0.1 + 0.2;
            double epsilon = 0.000000001;
            double expectedResult = 0.3;

            double difference = Math.abs(x - expectedResult);

            System.out.println(difference < epsilon ? "Fast 0.3" : "Nicht 0.3");

            // 3.3
            register("Max", 18);
            register(null, 28);
            register("Max", 3);

        }
    }
}
