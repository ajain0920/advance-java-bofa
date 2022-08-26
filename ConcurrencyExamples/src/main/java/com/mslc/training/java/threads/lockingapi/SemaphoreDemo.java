package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreDemo {


    public static void main(String[] args) throws InterruptedException {


        Semaphore semaphore = new Semaphore(3);
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();

        System.out.println("After acquiring 3 times");

        /**
         * After 5 seconds release 1 permit
         *
         */

        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                semaphore.release();
            }
        }.start();

        semaphore.acquire();
        System.out.println("Acquired the 4th time");


    }
}
