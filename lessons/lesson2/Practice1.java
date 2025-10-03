package lessons.lesson2;

import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1-task");
        task1();


        System.out.println("2-task. enter N:");
        int n2 = scanner.nextInt();
        System.out.println("result: ");
        task2(n2);

        System.out.println("3-task. enter N:");
        int n3 = scanner.nextInt();
        System.out.println("result: ");
        task3(n3);

        System.out.println("4-task. enter N:");
        int n4 = scanner.nextInt();
        System.out.println("result: ");
        task4(n4);

        System.out.println("5-task: N:");
        int n5 = scanner.nextInt();
        task5(n5);


        System.out.println("6-task . N: ");
        int n6 = scanner.nextInt();
        task6(n6);


        //task-7 is repeated

        System.out.println("8-task: ");
        task8();

        System.out.print("9- task. N: ");
        int N = scanner.nextInt();

        for (int i = 2; i <= N; i++) {
            if (task9(i)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

        System.out.println("task 10: ");
        task10();


        System.out.println("11- task . Enter a:");
        int a = scanner.nextInt();

        System.out.println("Enter b:");
        int b = scanner.nextInt();
        numExchange(a, b);

        System.out.println("12- task. multiplication table: ");
        multiplTable();

        System.out.println("13-task. enter the amount in dollars: ");
        int amount = scanner.nextInt();
        System.out.println("Converted amount to uzs: " + exchange(amount));


        System.out.println("14-task. enter N: ");
        int num = scanner.nextInt();
        oddEven(num);

        System.out.println("15-task(find max). enter a:");
        int a1 = scanner.nextInt();
        System.out.println("enter b:");
        int b1 = scanner.nextInt();
        System.out.println("enter c: ");
        int c1 = scanner.nextInt();

        System.out.println(" result:" + maxNum(a1, b1, c1));

        System.out.println("16-task .enter a: ");
        int first = scanner.nextInt();
        System.out.println("enter b: ");
        int sec = scanner.nextInt();
        System.out.println("choose (+-/*): ");
        char choice = scanner.next().charAt(0);
        calculate(first, sec, choice);


        System.out.print("17-task. Enter the number of elements (n): ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        double avg = calculateAverage(numbers);
        System.out.println("the average is: " + avg);

        System.out.println("enter the number of elements:");
        int numb = scanner.nextInt();

        int[] nums = new int[numb];
        System.out.println("enter " + n + " numbers: ");
        for (int i = 0; i < numb; i++) {
            nums[i] = scanner.nextInt();

        }

        System.out.println("enter the number to search: ");
        int target = scanner.nextInt();

        if (contains(nums, target)) System.out.println("the number " + numb + " is in the array");
        else System.out.println("the number " + target + " is not on the array");
    }


    public static void task1() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void task2(int n) {
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum += i;
        }
        System.out.println("sum from 1 to N is:" + sum);
    }

    public static void task3(int n) {
        int product = 1;
        for (int i = 1; i <= n; i++) {
            product *= i;
        }
        System.out.println("product from 1 to N is:" + product);
    }

    public static void task4(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                sum += i;
            }

        }
        System.out.println("sum of even numbers till N is: " + sum);


    }

    public static void task5(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("sum: " + sum);

    }

    public static void task6(int n) {
        StringBuilder c = new StringBuilder();
        while (n > 0) {
            c.append(n % 10);
            n /= 10;
        }
        System.out.println("result: " + c);
    }

    public static void task8() {
        int i = 1001;
        while (true) {
            if (i % 7 == 0) {
                System.out.println("number that is divisible by 7 :" + i);
                break;

            }
            i++;
        }


    }

    public static boolean task9(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static void task10() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 4; j > i; j--) {
                System.out.print(" ");

            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();

        }

        for (int i = 1; i <= 4; i++) {
            for (int j = 4; j > i; j--) {
                System.out.print(" ");

            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");

            }
            System.out.println();

        }
    }

    public static void numExchange(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("exchanged numbers: " + a + " " + b);
    }

    public static void multiplTable() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + "*" + j + "=" + (i * j) + "\t");

            }
            System.out.println();

        }

    }

    public static int exchange(int usd) {
        return 12500 * usd;
    }

    public static void oddEven(int n) {
        if (n % 2 == 0) {
            System.out.println("The number " + n + " is even");
        } else {
            System.out.println("The number " + n + " is odd");
        }

    }

    public static int maxNum(int a, int b, int c) {
        int max = 0;
        if (a > b && a > c) max = a;
        else if (b > a && b > c) max = b;
        else if (c > a && c > b) max = c;
        else if ((a = b) > c) max = a;
        else if ((a = c) > b) max = a;
        else if ((c = b) > a) max = c;
        else {
            System.out.println("a, b, c are equal. ");
        }
        return max;
    }

    public static void calculate(int a, int b, char c) {
        switch (c) {
            case '+':
                System.out.println(a + "+" + b + "=" + (a + b));
                break;

            case '-':
                System.out.println(a + "-" + b + "=" + (a - b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println(a + "/" + b + "=" + (a / b));
                } else {
                    System.out.println("cant divide by 0!!!");
                }
                break;
            case '*':

                System.out.println(a + "*" + b + "=" + (a * b));
                break;
            default:
                System.out.println("incorrect character, try again.");
        }

    }

    public static double calculateAverage(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return (double) sum / arr.length;
    }

    public static boolean contains(int[] arr, int k) {
        for (int num : arr) {
            if (num == k) {
                return true;
            }
        }
        return false;
    }

}





