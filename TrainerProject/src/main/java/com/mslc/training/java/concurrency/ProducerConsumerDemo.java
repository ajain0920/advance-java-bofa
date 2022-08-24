package com.mslc.training.java.concurrency;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerDemo {

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

        t1.start();
        Thread.sleep(100);

        Thread t2 = new Thread() {
            {
                setName("t2");
            }

            @Override
            public void run() {
                ds.put("Value 4");
            }
        };

        t2.start();

        Thread t3 = new Thread() {
            @Override
            public void run() {
                {
                    setName("t3");
                }

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                String value = ds.take();
                System.out.println("The value received is : " + value);
                ds.print();

            }
        };
        t3.start();

        new Thread() {

            {
                setDaemon(true);
            }

            @Override
            public void run() {

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);

                    }
                    System.out.println("Thread t2 : " + t2.getState().name() + " -- " + LocalDateTime.now());
                }
            }
        }.start();


    }

}


class MyBoundedDataStructure {

    private int size;
    private List<String> values = new ArrayList<>();

    MyBoundedDataStructure(int size) {

        this.size = size;

    }

    /**
     * I have repeated the word Condition 3 times
     *
     * @param value
     */
    public synchronized void put(String value) {

        while (values.size() == size) {
            try {
                System.out.println("Thread : " + Thread.currentThread().getName() + " is now going to wait ");
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        values.add(value);
        System.out.println("Inserted : " + value);

    }

    public synchronized String take() {
        String value = values.remove(0);

        this.notify();
        System.out.println("This guy : " + Thread.currentThread().getName() + " is naively not releasing the lock");
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return value;
    }


    public synchronized void print() {

        System.out.println(" --- " + values.size() + " --- ");
        values.forEach(System.out::println);

    }
}
