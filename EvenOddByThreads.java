/*
Print Even and Odd numbers using Wait and Notify
 */
package evenoddbythreads;
import static java.lang.System.out;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Karthikeyan_Varadara
 */
public class EvenOddByThreads {
    
    public static void main(String []args){
        PrintValues pv = new PrintValues();
        new Thread("Odd"){            
            public void run(){
                for(int i=0;i<5;i++){
                    try {
                        pv.odd();
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EvenOddByThreads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        
        new Thread("Even"){            
            public void run(){
                for(int i=0;i<5;i++){
                    try {
                        pv.even();
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(EvenOddByThreads.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }.start();
        
    }
}

class PrintValues{
    int count=1;
    boolean isEven;
    
    synchronized void odd(){
        if(isEven){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        out.println(count+" "+Thread.currentThread().getName());
        count++;
        isEven=true;
        this.notify();        
    }
    
    synchronized void even(){
        if(!isEven){
            try {
                this.wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(PrintValues.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        out.println(count+" "+Thread.currentThread().getName());              
        count++;
        isEven=false;
        this.notify();
    }
}