package com.mslc.training.java.threads.lockingapi;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerWithLockAPI {


    public static void main(String[] args) throws InterruptedException {

        MyBoundedDataStructure ds = new MyBoundedDataStructure(3);
        ds.put("Value 1");
        ds.put("Value 2");

        Thread t1 = new Thread() {
            {
                setName("t1");
            }
            @Override
            public void run() {
                ds.put("Value 3");
            }
        };

        Thread t2 = new Thread() {
            {
                setName("t2");
            }
            @Override
            public void run() {
                ds.put("Value 4");
            }
        };
        Thread t3 = new Thread() {
            {
                setName("t3");
            }

            @Override
            public void run() {
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String value = ds.take();
                System.out.println(value);
//                try {
//                    Thread.sleep(2);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
                ds.print();
            }
        };

        t1.start();
        Thread.sleep(1);
        t2.start();
        Thread.sleep(1);
        t3.start();

    }


}


class MyBoundedDataStructure {

    private int size;
    private List<String> values = new ArrayList<>();

    Lock lock = new ReentrantLock(true);
    Condition fullCondition = lock.newCondition();

    MyBoundedDataStructure(int size) {

        this.size = size;

    }

    /**
     * I have repeated the word Condition 3 times
     *
     * @param value
     */
    public void put(String value) {
        lock.lock();

        try {
            while (values.size() == size) {
                try {
                    System.out.println("Thread : " + Thread.currentThread().getName() + " is now going to await ");
                    fullCondition.await();
                    System.out.println("Out of await : " + LocalTime.now());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            values.add(value);
        } finally {

            lock.unlock();
        }


    }

    public String take() {
        lock.lock();
        try {
            String value = values.remove(0);
            fullCondition.signal();
            System.out.println("Signalled : " + LocalTime.now());
//            this.notify();
            return value;
        } finally {
            lock.unlock();
        }


    }


    public void print() {
        lock.lock();

        try {
            System.out.println(" --- " + values.size() + " --- ");
            values.forEach(System.out::println);
        } finally {
            lock.unlock();
        }

    }
}