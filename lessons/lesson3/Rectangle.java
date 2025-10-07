package lessons.lesson3;

import java.util.Scanner;

public class Rectangle {
    private float length;
    private float width;

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public static void calculateArea(float length, float width) {
        System.out.println("area: " + length * width);
    }

    public static void calculatePerimeter(float length, float width) {
        System.out.println("perimeter: " + 2 * (length + width));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter length of the rectangle: ");
        float length = scanner.nextFloat();
        System.out.println("enter width: ");
        float width = scanner.nextFloat();
        calculateArea(length, width);
        calculatePerimeter(length, width);
    }
}
