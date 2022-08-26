package com.mslc.training.java.threads.lockingapi;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {

    static ExecutorService service = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException {


        int totalTasks = 7;

        CountDownLatch cdl = new CountDownLatch(totalTasks);

        Random r = new Random();

        for (int i = 0; i < totalTasks; i++) {

            final int j = i;
            service
                    .execute(new Runnable() {
                        @Override
                        public void run() {
                            // send the job for processing


                            try {

                                Thread.sleep(r.nextInt(5000));
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            System.out.println("Task : " + j + " is completed in thread :  " + Thread.currentThread().getName());
//                            cdl.countDown();

                            DemoClass demoClass = new DemoClass();
                            demoClass.f1(cdl);
                        }
                    });
        }


        cdl.await(3, TimeUnit.SECONDS);
        System.out.println("Update the flag now.....");

        service.shutdown();
    }
}

class DemoClass {


    public void f1(CountDownLatch cdl) {

        new Thread() {
            @Override
            public void run() {

                cdl.countDown();

            }
        }.start();
    }

}
