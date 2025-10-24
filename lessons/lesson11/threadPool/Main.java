package lessons.lesson11.threadPool;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MyThreadPool pool = new MyThreadPool(3);
        Scanner scanner = new Scanner(System.in);

        System.out.println("task names: ");

        while(true){
            String str = scanner.nextLine();

            if(str.equalsIgnoreCase("exit")){
                pool.shutdown();
                break;
            }
            try {
                pool.submit(() -> {
                    System.out.println("task: " + str + "-- " + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();

                    }
                });
            } catch(InterruptedException e){
                e.printStackTrace();

            }
        }
        scanner.close();
    }
}
