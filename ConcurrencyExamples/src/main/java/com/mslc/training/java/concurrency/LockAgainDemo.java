package com.mslc.training.java.concurrency;


/**
 * Explaining Reentrant Locks
 *
 *
 */
public class LockAgainDemo {

    public static void main(String[] args) {
        LockAgain lockAgain = new LockAgain();

        new Thread() {
            @Override
            public void run() {
                lockAgain.f1();
                System.out.printf("All done");
            }
        }.start();


        new Thread() {
            @Override
            public void run() {
                lockAgain.f2();
                System.out.printf("All done");
            }
        }.start();

    }
}


class LockAgain {


    public synchronized void f1() {

        f2();

    }

    public synchronized void f2() {

        System.out.println("Th is in f2");

        ///
    }
}
