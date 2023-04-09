package com.mycompany.pr7;

public class Pr7 {
    public static void main(String[] args) throws Exception {
        System.out.println("RIBO-04-21 v4 Romanov I.V.");
        Thread thread1 = new Thread(new MyRunnable(), "Thread 0");
        Thread thread2 = new Thread(new MyRunnable(), "Thread 1");
        
        thread1.start();
        thread2.start();
    }
    
    static class MyRunnable implements Runnable {
        private static final Object lock = new Object();

        public void run() {
            while(true) {
                synchronized(lock) {
                    System.out.println(Thread.currentThread().getName());
                    lock.notify();
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        return;
                    }
                }
            }
        }
    }
}