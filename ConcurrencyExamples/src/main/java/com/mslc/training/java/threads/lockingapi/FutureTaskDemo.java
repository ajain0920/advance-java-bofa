package com.mslc.training.java.threads.lockingapi;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class FutureTaskDemo {
//    static List<Thread> threads = new ArrayList<>();


    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        System.out.println("Thread Pool is instantiated....");
//        try {
//            Thread.sleep(60000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        Future<Integer> distanceResult = service.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {

//                threads.add(Thread.currentThread());

                System.out.println("The task has started : " + Thread.currentThread().getName());
                /**
                 * I invoke Google API to get the distance between the two locations
                 *
                 */
                Thread.sleep(5000);
                if (true) {
                    throw new SQLException("There was error in storing data...");
                }
                return 10;
            }
        });


        Thread mainThread = Thread.currentThread();

        new Thread() {
            @Override
            public void run() {
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//                mainThread.interrupt();
            }
        }.start();
        System.out.println("After submitting the task");


        try {
            /**
             * Whenever the task is completed I will get the value
             */
            int i = distanceResult.get();
//            int i = distanceResult.get

            System.out.println("The value of distance is : " + i);
        } catch (InterruptedException e) {
            System.out.println("The thread that was getting the result got interrupted...");
        } catch (ExecutionException e) {

            System.out.println("The task threw an exception : " + e.getMessage() +  " -- " + e.getCause().getClass());

        }


        service.shutdown();


    }
}
