package lessons.lesson3;

import java.util.Scanner;

public class Car {
    private String country;
    private int year;
    private String model;

    public Car(String country, int year, String model) {
        this.country = country;
        this.year = year;
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "country='" + country + '\'' +
                ", year=" + year +
                ", model='" + model + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the car model : ");
        String model = scanner.nextLine();
        System.out.println("enter the year of manufacturing: ");
        int year = scanner.nextInt();

        scanner.nextLine();
        System.out.println("enter the country: ");
        String country = scanner.nextLine();

        Car car = new Car(country, year, model);
        System.out.println(car);
    }
}
