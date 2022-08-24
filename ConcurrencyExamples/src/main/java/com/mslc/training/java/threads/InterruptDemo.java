package com.mslc.training.java.threads;

import java.time.LocalTime;

public class InterruptDemo {

    static Thread threadToBeInterrupted = null;

    public static void main(String[] args) {


        Thread t1 = new Thread() {
            @Override
            public void run() {
                threadToBeInterrupted = Thread.currentThread();
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Coming out of the thread...");
                        break;
                    }

                    System.out.println("Some job being done by Thread : " + Thread.currentThread().getName() + " -- " + LocalTime.now());
                    /**
                     * Invoking A REST API with the help of RestTeplate
                     * // Executing SQL Statement.
                     */



//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        System.out.println("Thread is interrupted ");
//                        break;
//                    }
                }

            }
        };
        t1.start();
        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(" ----------------------------- Interrupting t1 ------------------- ");

                t1.interrupt();

            }
        }.start();


    }
}
