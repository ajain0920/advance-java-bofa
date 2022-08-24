package com.mslc.training.java.threads.lockingapi;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {


    public static void main(String[] args) throws InterruptedException {

        CachedData cachedData = new CachedData();
        cachedData.put("Value 1");
        cachedData.put("Value 2");

        new Thread() {
            {
                setName("t1 - writer");
            }

            @Override
            public void run() {
                cachedData.put("Value 3");
            }
        }.start();

        Thread.sleep(100);
        new Thread() {
            {
                setName("t2 - reader");
            }

            @Override
            public void run() {
                System.out.println(cachedData.get(1));
            }
        }.start();


        new Thread() {
            {
                setName("t3 - writer");
            }

            @Override
            public void run() {
                cachedData.put("Value - new");
            }
        }.start();


        Thread.sleep(100);
        new Thread() {
            {
                setName("t4 - reader");
            }

            @Override
            public void run() {
                System.out.println(cachedData.get(0));
            }
        }.start();

    }

}


class CachedData {


    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    Lock writeLock = readWriteLock.writeLock();
    Lock readLock = readWriteLock.readLock();


    private List<String> values = new ArrayList<>();


    public void put(String value) {

        writeLock.lock();
        try {
            values.add(value);
            if (value.equals("Value - new")) {
                System.out.println(Thread.currentThread().getName() + " is holding on to the lock");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            writeLock.unlock();
        }
    }

    public String get(int i) {

        readLock.lock();
        try {
            System.out.println("Thread : " + Thread.currentThread().getName() + " is reading the value");
            Thread.sleep(5000);
            return values.get(i);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            readLock.unlock();
        }


    }


}
