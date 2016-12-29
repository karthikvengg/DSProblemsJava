/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producerconsumer;
import java.util.*;
/**
 *
 * @author Karthikeyan_Varadara
 */
public class ProducerConsumer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main m = new Main();
        Producer t1 = new Producer(m);
        Consumer t2 = new Consumer(m);
        t1.start();
        t2.start();
    }    
}

class Main{
    Stack st=new Stack();
    boolean flag = true;
    public synchronized void put(int a){
        if(flag==true){
            st.add(a);
            System.out.println("Produced: "+a);
            flag=false;
        }        
    }
    
    public synchronized void get(){
        if(flag==false){                    
            Integer b = (Integer)st.pop();
            flag=true;
            System.out.println("Consumer: "+b);                 
        }        
    }   
}
class Producer extends Thread{    
    Main m;
    Producer(Main n){
        m=n;
    }
    @Override
    public void run(){
        for(int i=1;i<=10;i++){            
            m.put(i);
            try{
                Thread.sleep(1000);    
            }   
            catch(InterruptedException e){
                System.out.println(e);
            }
        }
    }
}


class Consumer extends Thread{
    Main m;
    Consumer(Main n){
        m=n;
    }
    @Override
    public void run(){
        for(int i=1;i<=10;i++){
            m.get();
            try{
                Thread.sleep(1000);    
            }   
            catch(InterruptedException e){
                System.out.println(e);
            }            
        }
    }    
}
