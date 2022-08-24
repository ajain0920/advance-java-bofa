package com.mslc.training.java.concurrency;

public class DeadLockDemo {


    public static void main(String[] args) throws InterruptedException {

        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread() {
            @Override
            public void run() {

                synchronized (lock1) {
                    System.out.println("t1 has acquired monitor of lock1");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    synchronized (lock2) {
                        System.out.println("t1 has acquired monitor lock2");
                    }


                }

            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {

                synchronized (lock2) {
                    System.out.println("t2 has acquired the monitor of lock2");

                    synchronized (lock1) {
                        System.out.println("t2 has acquired the monitor of lock1");
                    }
                }
            }
        };

        t1.start();
        Thread.sleep(100);
        t2.start();

        System.out.println("Last line of main");


    }
}
