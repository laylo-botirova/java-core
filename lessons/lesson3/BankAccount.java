package lessons.lesson3;

import java.util.Scanner;

public class BankAccount {
    private String fio;
    private double balance;
    private String accNumber;

    public BankAccount(String fio, String accNumber) {
        this.fio = fio;
        this.balance = 50000;
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("deposit: " + amount);
        } else {
            System.out.println("insufficient amount. ");
        }
    }

    public void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            System.out.println("withdrawn: " + amount);
        } else {
            System.out.println("insufficient funds.");
        }
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "fio='" + fio + '\'' +
                ", balance=" + balance +
                ", accNumber='" + accNumber + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("enter your full name (fio): ");
        String fio = scanner.nextLine();

        System.out.println("enter your account number: ");
        String accNum = scanner.nextLine();
        boolean exit = false;
        while (!exit) {
            System.out.println("choose action: 1) show my balance 2) deposit 3) withdraw 4) exit");
            int choice = scanner.nextInt();
            BankAccount ba = new BankAccount(fio, accNum);
            switch (choice) {
                case 1:
                    System.out.println("your balance: " + ba.getBalance());

                    break;
                case 2:
                    System.out.println("enter the deposit amount: ");
                    double amount = scanner.nextInt();
                    ba.deposit(amount);
                    System.out.println(ba.toString());

                    break;

                case 3:
                    System.out.println("enter withdrawal amount: ");
                    int withdrAmount = scanner.nextInt();
                    ba.withdraw(withdrAmount);
                    System.out.println(ba.toString());
                    break;

                case 4:
                    System.out.println("exiting...");
                    exit = true;
                    break;

                default:
                    System.out.println("incorrect option, please try again");
            }
        }
        scanner.close();

    }
}
