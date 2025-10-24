package lessons.lesson11.subscriberPublisher;

import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Publisher implements Runnable{
    private BlockingQueue <String> queue;

    public Publisher(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your word: ");
        try
        {
            while (true){
                String word = scanner.nextLine();
                queue.put(word);
                if(word.equalsIgnoreCase("exit")){
                    break;
                }
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
