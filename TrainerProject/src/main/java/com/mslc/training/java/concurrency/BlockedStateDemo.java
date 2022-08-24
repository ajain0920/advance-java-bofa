package com.mslc.training.java.concurrency;

import java.time.LocalDateTime;

/**
 *
 */
public class BlockedStateDemo {

    public static void main(String[] args) throws InterruptedException {

        HitCounter.incrementCommonCount();

        MyInteger i = new MyInteger(50);

        Thread t1 = new Thread() {
            @Override
            public void run() {

                i.increment();
            }
        };

        Thread t2 = new Thread() {
            @Override
            public void run() {

                i.increment();
                int val = i.getValue();
                System.out.println("The new value is : " + val);
            }
        };

        t1.start();
        Thread.sleep(100);
        t2.start();

        new Thread() {
            {
                setName("Monitor Thread");
                setDaemon(true);
            }

            @Override
            public void run() {
                while (true) {
                    System.out.println("Thread t2 : " + t2.getState().name() + " - " + LocalDateTime.now());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();


    }

}

class MyInteger {
    private int value;


//    Object lock = new Object();

    MyInteger(int value) {
        this.value = value;
    }


    public void setValue(int value) {

        /**
         * 10 more lines code
         */
        synchronized (this) {

            this.value = value;

        }

    }


    /**
     * Invalidate the local cache and read the data from main memoruy
     *
     * @return
     */
    public int getValue() {  //  (Memory Fences)  Read-Barrier :  Invalidate the local cache and read the data from main memoruy

//        StringBuilder b = new StringBuilder();

//        StringBuffer
        synchronized (this) {
            return this.value;
        }


    }

    public void increment() {

        synchronized (this) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            value++;
        }

    } // (Memory Fences)  Write-Barrier  flush the value of the variable bac to main memory

}
