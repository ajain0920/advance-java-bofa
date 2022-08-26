package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicVariableDemo {

    /**
     * Customer ( id, name, customer, version )
     * // Select 1 from Customer where id = 101 for update ;
     * <p>
     * Select * from customer where id = 101;
     * result : 101, BoA, Chennai, 10
     * <p>
     * <p>
     * <p>
     * Chennai -> Madurai
     * <p>
     * Update Customer set address = Madurai , version = 11
     * where id = 101 and version = 10
     *
     * @param args
     */
    public static void main(String[] args) {

        MyCounter c = new MyCounter();
        c.increment();
    }

}


class MyCounter {

    private AtomicInteger count;

    public void increment() {
        count.getAndIncrement();
//        count.
//        count.


//        count++;

//        count = count + 1;
    }


}
