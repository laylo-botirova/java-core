package lessons.lesson11.subscriberPublisher;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        Publisher publisher = new Publisher(queue);
        Subscriber subscriber= new Subscriber(queue);
        Thread publisherThread = new Thread(publisher);
        Thread subscrThread = new Thread(subscriber);

        publisherThread.start();
        subscrThread.start();

        try {
            publisherThread.join();
            subscrThread.join();
        } catch (InterruptedException e) {
e.printStackTrace();        }
       }

}
