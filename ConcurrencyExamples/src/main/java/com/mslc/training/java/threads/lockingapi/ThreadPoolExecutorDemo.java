package com.mslc.training.java.threads.lockingapi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;


public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {


        BlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(15);
//        BlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();


        ThreadPoolExecutor tpe = new ThreadPoolExecutor(10, 10, 3, TimeUnit.SECONDS, taskQueue, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                System.out.println("The task : " + r + " was rejected");

            }
        });

        CountDownLatch cdl = new CountDownLatch(10);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 26; i++) {

            final int j = i;
            tpe.execute(new Runnable() {
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


        tpe.shutdown();


    }
}
