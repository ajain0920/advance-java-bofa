package com.mslc.training.java;

import com.mslc.training.java.model.Customer;

public class DaemonThread {


    public static void main(String[] args) throws InterruptedException {


        System.out.println(Runtime.getRuntime().freeMemory());


//
//        Customer.totalCustomers = 5000;
//        Customer.totalCustomers = 5001;


        new Thread() {

            {
//                setName("My Thread");
//                setDaemon(true);
            }

            @Override
            public void run() {
                System.out.println("This is the thread : " + Thread.currentThread().getName() + " -- " + Thread.currentThread().isDaemon());
                try {
                    Thread.sleep(Long.MAX_VALUE);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


            }
        }.start();

        System.out.println("Thread : " + Thread.currentThread().getName());

        f1();
        Thread.sleep(Long.MAX_VALUE);

    }


    public static void f1() {

        ///
        f2();
    }

    public static void f2() {


//        f3();

    }

    public static void f3() {


        Customer cust = new Customer();


    }

}
