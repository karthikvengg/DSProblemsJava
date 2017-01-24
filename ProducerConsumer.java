/*
Producer Consumer using Notify and Wait methods
 */
package producerconsumer;
import java.util.Random;
import static java.lang.System.out;
import java.util.Stack;

/**
 *
 * @author Karthikeyan_Varadara
 */
public class ProducerConsumer {
    
    public static void main(String[] args) {
        ProducerConsumerDemo pc = new ProducerConsumerDemo();
        
        new Thread("One"){
            public void run(){
                for(int i=0;i<10;i++){
                    try {
                        pc.produce();
                        Thread.sleep(200);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        }.start();
        
        new Thread("Two"){
            public void run(){
                for(int i=0;i<10;i++){
                    try {
                        pc.consume();
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        
                    }
                }
            }
        }.start();
        
    }   
}

class ProducerConsumerDemo{
    Random r = new Random();
    int n;
    Stack st = new Stack();
    synchronized void produce(){
        if(st.size()==5){
            out.println("Waiting to be consumed..");
            try{
                this.wait();
            }                
            catch(InterruptedException ex){
                
            }          
        }
        n = r.nextInt(100);
        st.push(n);
        out.println("Produced: "+n);
        this.notify();
    }
    synchronized void consume(){
        if(st.size()==0){
            out.println("Waiting for the producer to produce..");
            try{
                this.wait();
            }                
            catch(InterruptedException ex){
                
            }           
        }        
        out.println("Consumed: "+st.pop());
        this.notify();        
    }
}


