package lessons.lesson2;

import java.util.Scanner;

public class QuestGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("you wake up on cold sand near a lake");
        System.out.println("your phone is almost dead. in your pocket there is a match and a note: \"don’t trust the voices. go north.\"");
        System.out.println("where do you go? choose 1-3");
        System.out.println("1. east (there is light) ");
        System.out.println("2. north (follow the note) ");
        System.out.println("3. stay at the lake ");

        int choice1 = sc.nextInt();

        if (choice1 == 1) {
            System.out.println("you walk east and find a power station");
            System.out.println("stop. show id");
            System.out.println("1. i am human! ");
            System.out.println("2. run into the forest ");
            int choice2 = sc.nextInt();

            if (choice2 == 1) {
                System.out.println("you wake up in a lab.");
                System.out.println("ending: failure");
            } else {
                System.out.println("you run, but vanish without a trace.");
                System.out.println("ending: failure");
            }

        } else if (choice1 == 2) {
            System.out.println("you go north and find an abandoned village.");
            System.out.println("in a diary you read: the lake wakes up at full moon");
            System.out.println("1. stay until sunrise ");
            System.out.println("2. keep walking ");
            int choice2 = sc.nextInt();

            if (choice2 == 1) {
                System.out.println("survivors find you.");
                System.out.println("ending: victory");
            } else {
                System.out.println("you reach a lighthouse and find a radio. rescue comes!");
                System.out.println("ending: victory");
            }

        } else {
            System.out.println("you stay by the lake. you hear a voice: help me...");
            System.out.println("1. go to the voice ");
            System.out.println("2. run into the forest ");
            int choice2 = sc.nextInt();

            if (choice2 == 1) {
                System.out.println("shadows surround you.");
                System.out.println("ending: curse of the lake");
            } else {
                System.out.println("you find an underground bunker with equipment.");
                System.out.println("1. destroy the control center ");
                System.out.println("2. join the project ");
                int choice3 = sc.nextInt();

                if (choice3 == 1) {
                    System.out.println("you start self-destruction. you save the world but die.");
                    System.out.println("ending: hero");
                } else {
                    System.out.println("you join the project and become part of it.");
                    System.out.println("ending: secret member");
                }
            }
        }

        sc.close();
    }
}
