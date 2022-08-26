package com.mslc.training.java.threads.lockingapi;

import java.util.Collections;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * We have learnt : CountDownLatch, Semaphore, CyclicBarrier
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {


        int totalParties = 7;
        ExecutorService service = Executors.newFixedThreadPool(totalParties);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalParties, new Runnable() {
            @Override
            public void run() {
                System.out.println("The barrier is reset :  " + Thread.currentThread().getName());
            }
        });

        Random r = new Random();

        for (int i = 0; i < totalParties; i++) {

            final int j = i;
            service.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("Task : " + j + " is executing in : " + Thread.currentThread().getName());
                    int sleepTime = r.nextInt(10000);
                    System.out.println("Thread : " + Thread.currentThread().getName() + " will sleep for " + sleepTime);



                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (j == 2) {
//                        Thread.currentThread().interrupt();
                    }
                    try {
                        System.out.println(" ----- " + Thread.currentThread().getName() + " has arrived...");
                        cyclicBarrier.await();
                        System.out.println("All threads have arrived : " + Thread.currentThread().getName());

                    } catch (InterruptedException e) {

                        System.out.println("The Thread : " + Thread.currentThread().getName() + " got interrupted...");

                    } catch (BrokenBarrierException e) {

                        System.out.println("The Thread : " + Thread.currentThread().getName() + " has encountered BrokenBarrierException");
                    }
                }
            });

        }

        service.shutdown();


    }
}
