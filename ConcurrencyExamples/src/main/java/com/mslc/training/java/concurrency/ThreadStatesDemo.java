package com.mslc.training.java.concurrency;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * NEW !
 * RUNNABLE !
 * BLOCKED !
 * WAITING !
 * TIMED_WAITING !
 * TERMINATED !
 *
 * DeadLockDemo
 *
 */
public class ThreadStatesDemo {


    public static void main(String[] args) {

        Thread t1 = new Thread() {

            @Override
            public void run() {

                try {

                    /**
                     *
                     * Some code which invokes a complex & a long running Query on
                     * the remote database and it is taking 2 mins. What will be the state
                     * of the thread from which you have invoked this query (JDBC in java) ?
                     *
                     *
                     */
                    ServerSocket serverSocket = new ServerSocket(7001);
                    System.out.println("Server has started in : " + Thread.currentThread());

                    Socket socket = serverSocket.accept();
                    System.out.println("Connection request received : " + Thread.currentThread().getName());

                    byte[] bytes = new byte[100];
                    socket.getInputStream().read(bytes);
                    System.out.println("Data received ....." + new String(bytes));


                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        };

        t1.start();

        new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("The state of Thread t1 is : " + t1.getState().name() + " -- " + LocalDateTime.now());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.start();


    }


}
