/*
Producer Consumer Problem with Blocking Queue and Thread using Executor Service
 */
package ProducerConsumer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        BlockingQueue queue = new ArrayBlockingQueue(5);
        //Executors.newSingleThreadExecutor();
        //Executors.newFixedThreadPool(10);
        //Executors.newScheduledThreadPool(10);
        ExecutorService executor=Executors.newFixedThreadPool(2);
        Demo d = new Demo(queue);
        executor.execute(new Runnable(){
            public void run(){
                for(int i=0;i<5;i++){
                    try {
                        d.produce(i);
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        Future future = executor.submit(new Callable(){
            public String call(){
                for(int i=0;i<5;i++){
                    try {
                        d.consume();
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                return "Done";
            }
        });
        System.out.println(""+future.get());
        executor.shutdown();                
    }   
}

class Demo{
    BlockingQueue queue;
    
    Demo(BlockingQueue queue){
        this.queue=queue;
    }
    void produce(int i){
        try {
            queue.put(i);
            System.out.println("Produced: "+ i);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void consume(){
        int j;
        try {
            j=(Integer)queue.take();
            System.out.println("Consumed: "+j);
        } catch (InterruptedException ex) {
            Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}