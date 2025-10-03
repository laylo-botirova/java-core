package lessons.lesson2;
import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int number = rand.nextInt(10) + 1;
        int guess = 0;

        System.out.println("Guess the number 1-10");

        while (guess != number) {
            guess = sc.nextInt();

            if (guess < number) {
                System.out.println("too small");
            } else if (guess > number) {
                System.out.println("too big");
            } else {
                System.out.println("Correct!");
            }
        }
    }
}

