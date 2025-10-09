package Exercises;

public class User {
    private String userName;
    private int age;
    // constructor
    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
    public String getUserName() {
        return userName;
    }
    public int getAge() {
        return age;
    }
    public void printUser() {
        System.out.printf("------------------------%n");
        System.out.printf("| %-10s | %-8s | %n", "NAME", "AGE");
        System.out.printf("------------------------%n");
        System.out.printf("| %-10s | %-8s | %n", userName, age);
        System.out.printf("------------------------%n");
    }
}
