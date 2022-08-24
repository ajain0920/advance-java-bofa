package com.mslc.training.java.threads;

public class JoinDemo {


    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread() {

            @Override
            public void run() {
                System.out.println("Thread Started.....");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + " has finished doing its job...");
            }
        };


        //t1.start();
        //Thread.currentThread().join();
        t1.join();

        System.out.println("The Thread t1 has completed doing its job........");


    }
}
