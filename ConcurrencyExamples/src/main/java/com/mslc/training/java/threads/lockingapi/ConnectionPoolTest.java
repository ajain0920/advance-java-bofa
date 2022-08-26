package com.mslc.training.java.threads.lockingapi;

public class ConnectionPoolTest {

    public static void main(String[] args) {

        ConnectionPoolWithSemaphore pool = new ConnectionPoolWithSemaphore(3);

        Object c1 = pool.getConnection();
        System.out.println("c1 : " + c1.hashCode());

        new Thread() {
            @Override
            public void run() {
                Object c2 = pool.getConnection();
                System.out.println("c2 : " + c2.hashCode());
            }
        }.start();


        Object c3 = pool.getConnection();
        System.out.println("c3 : " + c3.hashCode());

        System.out.println(" --- Acquired all 3 successfully ");


        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                pool.closeConnection(c3);
            }
        }.start();

        Object moreConnection = pool.getConnection();
        System.out.println("moreConnection : " + moreConnection.hashCode());

        System.out.println("Could acquire again");


    }
}
