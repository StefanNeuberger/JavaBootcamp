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

    }
}

