package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class CompletableFutureDemo {


    public static void main(String[] args) throws InterruptedException, ExecutionException {


        System.out.println(ForkJoinPool.commonPool().getParallelism());

        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                    System.out.println("Thread : " + Thread.currentThread().getName());
                    /**
                     * Invoke some API 1
                     *
                     */
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return "Response1";

                })
                .whenComplete((x, y) -> {
                    System.out.println("whenComplete executes in : " + Thread.currentThread().getName());

                    if (y == null) {
                        System.out.println("The value received from the task is : " + x);
                    } else {
                        System.out.println("whenComplete ....Error encountered : " + y.getMessage());
                    }

                }).handleAsync((x, y) -> {
                    System.out.println("handle executes in : " + Thread.currentThread().getName());

                    if (y == null) {
                        // Invoke API 2
                        return x + " Response 2";
                    } else {
                        System.out.println("handle.... Error encountered : " + y.getMessage());
                        return null;
                    }
                })
                .whenComplete((x, y) -> {
                    System.out.println("The final value : " + x);
                });



        System.out.println("In main.....");


        Thread.sleep(10000);


    }
}
