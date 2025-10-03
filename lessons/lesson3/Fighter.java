package lessons.lesson3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fighter {
    private String code;
    private String name;
    private int health;
    private int attack;

    public Fighter(String code, String name, int health, int attack) {
        this.code = code;
        this.name = name;
        this.health = health;
        this.attack = attack;
    }

    private static ArrayList<Fighter> fighters = new ArrayList<>();

    public void getFighterInfo() {
        System.out.println("Fighter{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", health=" + health +
                ", attack=" + attack +
                '}');
    }

    public static void getFighters() {
        if (fighters.isEmpty()) {
            System.out.println("No fighters yet");
        } else {
            for (Fighter f : fighters) {
                f.getFighterInfo();
            }
        }
    }

    public static void addFighter(String code, String name, int health, int attack) {
        Fighter f = new Fighter(code, name, health, attack);
        fighters.add(f);
        System.out.println("Fighter " + name + " added");
    }

    public static Fighter findByCode(String code) {
        for (Fighter f : fighters) {
            if (f.code.equals(code)) return f;
        }
        return null;
    }

    public static void fight(Fighter f1, Fighter f2) {
        Random r = new Random();
        Fighter attacker, defender;

        if (r.nextBoolean()) {
            attacker = f1;
            defender = f2;
        } else {
            attacker = f2;
            defender = f1;
        }

        System.out.println("Fight between " + f1.name + " and " + f2.name + " begins!");
        System.out.println(attacker.name + " starts the attack!");

        while (f1.health > 0 && f2.health > 0) {
            defender.health -= attacker.attack;
            System.out.println(attacker.name + " hit " + defender.name +
                    " for " + attacker.attack + ". " + defender.name +
                    " health left: " + defender.health);

            if (defender.health <= 0) {
                System.out.println(attacker.name + " wins!");
                return;
            }

            Fighter temp = attacker;
            attacker = defender;
            defender = temp;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        addFighter("F1", "Ryu", 100, 20);
        addFighter("F2", "Ken", 100, 18);
        addFighter("F3", "Chun-Li", 90, 22);

        while (true) {
            System.out.println("Menu: 1) show fighters 2) add fighter 3) fight 4) exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    getFighters();
                    break;
                case 2:
                    System.out.println("Enter code:");
                    String code = scanner.nextLine();
                    System.out.println("Enter name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter health:");
                    int health = scanner.nextInt();
                    System.out.println("Enter attack:");
                    int attack = scanner.nextInt();
                    addFighter(code, name, health, attack);
                    break;
                case 3:
                    System.out.println("Enter first fighter code:");
                    String c1 = scanner.nextLine();
                    Fighter f1 = findByCode(c1);
                    System.out.println("Enter second fighter code:");
                    String c2 = scanner.nextLine();
                    Fighter f2 = findByCode(c2);
                    if (f1 != null && f2 != null) {
                        fight(f1, f2);
                    } else {
                        System.out.println("One fighter not found");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
