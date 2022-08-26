package com.mslc.training.java.threads.projectreactor;

import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FluxDemo {

    public static void main(String[] args) {


        List<String> names = Arrays.asList("Morgan Stanley",
                "JP Morgan",
                "Bank of America",
                "BNP Pariba",
                "Wells Fargo",
                "Goldman Sasch",
                "CitiBank");


        Flux<String> stringFlux = Flux.fromIterable(names);

        stringFlux
                .log()

                .map(x ->{

//                    System.out.println(Thread.currentThread().getName());
                    return  x.toUpperCase();
                })
                .filter(x -> x.contains("MORGAN"))
                .subscribe(System.out::println);

        System.out.println("After flux");


    }
}
