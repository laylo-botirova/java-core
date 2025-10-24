package lessons.lesson11.subscriberPublisher;

import java.util.concurrent.BlockingQueue;
// listener
public class Subscriber implements Runnable{
    private BlockingQueue <String> queue;

    public Subscriber(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    public void run(){
        try{
            while(true){
                String msg = queue.take();
                if(msg.equalsIgnoreCase("exit")) {
                    break;
                }
                System.out.println("received message is-"+ msg);

            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
