package com.mslc.training.java.threads.lockingapi.functionalinterfaces;

import com.mslc.training.java.model.Customer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class WorkingWithLists {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("BoA", "Verizon", "JPMC", "Morgan Stanley");

//        names.forEach(x -> {
//            System.out.println(x);
//        });
        names.forEach(System.out::println);
        Comparator<Customer> comparator = (c1, c2) -> c1.getId().compareTo(c2.getId());


    }
}
