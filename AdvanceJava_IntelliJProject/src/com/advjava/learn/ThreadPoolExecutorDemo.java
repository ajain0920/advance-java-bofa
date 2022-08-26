package com.advjava.learn;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) throws InterruptedException {

        ThreadPoolExecutor te = new ThreadPoolExecutor(5, 5,
                5000L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(15));
        int taskCount = 0;
        CountDownLatch cl = new CountDownLatch(50);
        Semaphore lock = new Semaphore(19); // Size = Blocking que size + Thread Pool Size -- not working for 20 but for 19
        while(taskCount < 50) {
            final int task = taskCount++;
            lock.acquire();
            te.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("Task running: Task" + task +
                            " in thread " + Thread.currentThread().getName());
                    cl.countDown();
                    try{

                    }finally{
                        lock.release();
                    }

                }
            });


        }
        cl.await();
        te.shutdown();
    }
}
