package lessons.lesson11.threadPool;

public class Worker extends Thread{

   private final MyThreadPool pool;
    public Worker (String name, MyThreadPool pool){
        super(name);
        this.pool= pool;
    }

    @Override
    public void run() {
        while(!pool.isShutdown()){
            try{
                Runnable task = pool.getQueue().take();
                task.run();
            } catch(InterruptedException e ){
                System.out.println(getName()+" interrupted");
                break;
            }
        }
        System.out.println(getName()+ " stopped.");
           }
}
