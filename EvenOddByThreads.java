package test;

public class EvenOddByThreads {
    static int count;
    static EvenOddByThreads t = new EvenOddByThreads();
    static boolean flag = true;
    public static void main(String[] args) {

        new Thread(new Runnable() {
            public void run() {
                t.increment();
            }
        },"Odd").start();
        new Thread(new Runnable() {
            public void run() {
                t.increment();
            }
        },"Even").start();
    }

    synchronized void increment(){
        for(int i=0;i<10;i++) {
            if(flag) {
                count++;
                System.out.println(count + " By " + Thread.currentThread().toString());
                try {
                    Thread.sleep(500);
                    flag=false;
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                flag=true;
                this.notify();
            }
        }
    }
}
