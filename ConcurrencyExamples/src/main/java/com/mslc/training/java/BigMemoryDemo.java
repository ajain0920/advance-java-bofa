package com.mslc.training.java;

import com.mslc.training.java.model.Customer;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;


/**
 * How to find Memory Leaks.
 */
public class BigMemoryDemo {

    public static void main(String[] args) throws InterruptedException {


        ByteBuffer bf = ByteBuffer.allocate(300 * 1024 * 1024);

        List<Customer> customers = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            customers.add(new Customer(i, "BoA " + i));
        }

        System.out.println("300 MB Allocated....");
        Thread.sleep(Long.MAX_VALUE);


    }
}
