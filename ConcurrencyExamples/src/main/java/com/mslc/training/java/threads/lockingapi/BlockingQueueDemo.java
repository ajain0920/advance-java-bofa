package com.mslc.training.java.threads.lockingapi;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {

        // Bounded DataStructure
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(3);
        bq.put("Value 1");
        bq.put("Value 2");
        bq.put("Value 3");
        System.out.println("3 values already put");
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    //String value = bq.take();
                    System.out.println("The value is : " + bq.take());
                    Thread.sleep(5000);
                    bq.put("Value 5");
                    System.out.println("After value 5 inserted");

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }.start();

        // add & offer
        boolean wasSuccessful = bq.offer("Value 4", 4500, TimeUnit.MILLISECONDS);
        System.out.println("After value 4 : " + wasSuccessful);

        while(bq.size()>0){
            bq.take();
        }
        System.out.println("All values removed");
        String value = bq.take();
        System.out.println(value);




    }

}
