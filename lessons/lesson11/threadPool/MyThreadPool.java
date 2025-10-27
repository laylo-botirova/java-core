package lessons.lesson11.threadPool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {
    private final int size;
    private final Worker[] workers;
    private final BlockingQueue<Runnable> queue;
    private volatile boolean isShutdown = false;

    public MyThreadPool(int size) {
        this.size = size;
        this.workers = new Worker[size];
        ;
        this.queue = new LinkedBlockingQueue<>();

        for (int i = 0; i < size; i++) {
            workers[i] = new Worker("thread " + i, this);
            workers[i].start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        if (!isShutdown) {
            queue.put(task);
        } else {
            throw new IllegalStateException("cant accept new tasks!");
        }
    }
    public void shutdown(){
        isShutdown= true;
        for(Worker worker: workers){
            worker.interrupt();
        }
        System.out.println("Pool shut down.");
    }

    public boolean isShutdown() {
        return isShutdown;
    }

    public BlockingQueue<Runnable> getQueue() {
        return queue;
    }

    public Worker[] getWorkers() {
        return workers;
    }

    public int getSize() {
        return size;
    }
}
