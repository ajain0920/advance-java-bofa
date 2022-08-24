package com.mslc.training.java.threads;

public class ThreadLocalDemo {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) throws InterruptedException {


        Thread t1 = new Thread() {
            @Override
            public void run() {

                threadLocal.set("T1");

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(threadLocal.get());
            }
        };


        Thread t2 = new Thread() {
            @Override
            public void run() {

                System.out.println("The value being set into the ThreadLocal Object is  T2");
                threadLocal.set("T2");
                System.out.println("The value in ThreadLocal Object is  T2: "+ threadLocal.get());
                try {
                    int counter=0;
                    while ( counter<15){
                        Thread.sleep(1000);
                        counter++;
                }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("The value in ThreadLocal Object is  T2: "+ threadLocal.get());
            }
        };

        t1.start();
        Thread.sleep(3000);
        t2.start();





    }
}
