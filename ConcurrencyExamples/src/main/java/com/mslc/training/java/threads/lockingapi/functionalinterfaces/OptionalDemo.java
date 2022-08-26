package com.mslc.training.java.threads.lockingapi.functionalinterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {


        List<String> names = new ArrayList<>();

//                Arrays.asList("BoA", "Verizon", "JPMC", "Morgan Stanley");

        Optional<String> optionalName = names
                .stream()
                .findFirst();

//        if (optionalName.isPresent())
//            System.out.println(optionalName.get());

//        String value = optionalName
//                .orElseGet(() -> {
//                    /**
//                     *
//                     */
//                    return "default";
//                });


        String value = optionalName
                .orElseThrow(() -> {
                    return new RuntimeException("The value that was requested from the database is not available");
                });


        System.out.println(value);


    }
}
