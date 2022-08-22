package com.advjava.learn;

public class DemonThreadClass {

    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().setName("Main Thread");
//        Thread.currentThread().setDaemon(true);
        System.out.println("Current Thread: " + Thread.currentThread().getName()
                + " is Daemon: " + Thread.currentThread().isDaemon());

       Thread myThread =  new Thread(){
            @Override
            public void run(){
                Thread.currentThread().setName("My Thread");
                try{
                    Thread.sleep(5000);
                    System.out.println("Current Thread: " + Thread.currentThread().getName()
                            + " is Daemon: " + Thread.currentThread().isDaemon());
                }catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        myThread.setDaemon(true);
        myThread.start();
        Thread.sleep(Long.MAX_VALUE);
    }
}
