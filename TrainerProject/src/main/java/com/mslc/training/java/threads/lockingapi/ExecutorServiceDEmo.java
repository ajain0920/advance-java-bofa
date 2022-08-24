package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ExecutorServiceDEmo {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(Runtime.getRuntime().availableProcessors());


//        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorService executorService = Executors.newCachedThreadPool();

        CountDownLatch cdl = new CountDownLatch(10);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 30; i++) {

            final int j = i;
            executorService.execute(new Runnable() {
                @Override
                public void run() {

                    System.out.println("Task " + j + " is running in  : " + Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    cdl.countDown();
                }
            });
        }


        cdl.await();
        long end = System.currentTimeMillis();
        System.out.println("The total time taken is : " + (end - start));

        executorService.shutdown();


    }
}
