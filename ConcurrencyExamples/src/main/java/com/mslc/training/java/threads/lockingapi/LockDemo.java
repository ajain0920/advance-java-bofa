package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {


    public static void main(String[] args) throws InterruptedException {
        MyInteger i = new MyInteger();


        Thread t1 = new Thread() {
            @Override
            public void run() {
                i.setValue(60);
            }
        };


        Thread t2 = new Thread() {
            @Override
            public void run() {
                i.setValue(75);
                System.out.println(i.getValue());
            }
        };

        t1.start();
        Thread.sleep(100);
        t2.start();

        /**
         *
         * Write some code over here which will interrupt the Thread t2 after 3 seconds
         */
        Thread.sleep(3000);
        t1.interrupt();
/*        new Thread(){
            @Override
            public void run(){
                try {
                    Thread.sleep(3000);
                    t1.interrupt();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

        new Thread() {

            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                t2.interrupt();

            }
        }.start();

            }
        }.start();*/

    }
}


class YetAnotherClass {
    public void f1(MyInteger i) {
//        MyInteger i = new MyInteger();
        i.setValue(30);
        i.increment();
    }
}


/**
 * This data structure is thread safe
 */
class MyInteger {


    /**
     * there is no need to use Lock API unless you want features like
     * tryLock, tryLock with Timeout, lockInterruptibly.
     */
    Lock lock = new ReentrantLock(true);


    private int value;


    public void setValue(int value) {


        boolean lockAcquiredSuccessfully = false;
        try {
            lock.lockInterruptibly();
            lockAcquiredSuccessfully = true;
            System.out.println("Thread : " + Thread.currentThread().getName() + " has acquired lock");
            this.value = value;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " has acquired the lock and is interrupted while it was sleeping");
            }
            /**
             * some other lines of code
             */
        } catch (InterruptedException e) {
            System.out.println("The Thread " + Thread.currentThread().getName() + " was interrupted while it was trying to acquire the lock");
        } finally {

            if (lockAcquiredSuccessfully)
                lock.unlock();
        }


    }

    public int getValue() {
        try {
            lock.lock();
            return this.value;

        } finally {

            lock.unlock();
        }
    }

    public void increment() {
        try {
            lock.lock();
            this.value++;
        } finally {

            lock.unlock();
        }
    }

}
