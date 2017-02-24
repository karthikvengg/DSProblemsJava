/*
Producer Consumer Problem with Blocking Queue
 */
package ProducerConsumer;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BlockingQueue queue = new ArrayBlockingQueue(5);
        Demo d = new Demo(queue);
        new Thread("Producer"){
            public void run(){
                for(int i=0;i<5;i++){
                    try {
                        d.produce(i);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        new Thread("Producer"){
            public void run(){
                for(int i=0;i<5;i++){
                    try {
                        d.consume();
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BubbleSort.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
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