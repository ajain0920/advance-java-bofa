package com.mslc.training.java.threads.lockingapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Morgan Stanley",
                "JP Morgan",
                "Bank of America",
                "BNP Pariba",
                "Wells Fargo",
                "Goldman Sasch",
                "CitiBank");

        long start = System.currentTimeMillis();
        List<String> processedNames = names
                .parallelStream()
                .map(x -> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(x + " is being transformed in : " + Thread.currentThread().getName());
                    return x.toUpperCase();
                })
                .filter(x -> {

//                    System.out.println(x + " is being filtered in : " + Thread.currentThread().getName());

                    return x.contains("MORGAN");
                })
                .collect(Collectors.toList());
        long end = System.currentTimeMillis();
        System.out.println(processedNames + " -- " + (end - start));


    }
}
