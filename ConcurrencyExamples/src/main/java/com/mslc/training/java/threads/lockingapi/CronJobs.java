package com.mslc.training.java.threads.lockingapi;

import java.time.LocalTime;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class CronJobs {


    public static void main(String[] args) {

//        ExecutorService service = Executors.newFixedThreadPool(10);

        ScheduledExecutorService service = Executors.newScheduledThreadPool(100);

//        service.schedule(() -> {
//            System.out.println("This task will initiate after 5 seconds");
//
//        }, 5, TimeUnit.SECONDS);
//


//        service.scheduleAtFixedRate(() -> {
        service.scheduleWithFixedDelay(() -> {

            System.out.println("The task is executing : " + LocalTime.now());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, 3, 1, TimeUnit.DAYS);


        System.out.println("The task is scheduled to execute....");

//        service.shutdown();
    }

//    @Scheduler ()
//    public void syncData() {
//        if (!approved)
//            return
//
//
//
//    }
}
