package lessons.lesson3;

import java.util.Scanner;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public static void introduce(String name, int age){
        System.out.println("Hi! I am "+name+". I am "+age+" years old.");

    }
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        System.out.println("enter your name: ");
        String name = scanner.nextLine();
        System.out.println("enter your age: ");
        int age = scanner.nextInt();

        System.out.println("result: ");
        introduce(name, age);
    }
}


