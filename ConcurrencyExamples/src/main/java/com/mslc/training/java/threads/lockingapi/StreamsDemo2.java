package com.mslc.training.java.threads.lockingapi;

import com.mslc.training.java.model.Customer;
import com.mslc.training.java.model.CustomerAddress;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamsDemo2 {

    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(

                new Customer(101, "BoA",
                        Arrays.asList(new CustomerAddress(1, "Chennai"),
                                new CustomerAddress(1, "Hyderabad"),
                                new CustomerAddress(1, "Gurugram"))),

                new Customer(102, "IBM",
                        Arrays.asList(new CustomerAddress(1, "Pune"),
                                new CustomerAddress(1, "Hyderabad"),
                                new CustomerAddress(1, "Delhi"))),

                new Customer(103, "InfoSys",
                        Arrays.asList(new CustomerAddress(1, "Pune"),
                                new CustomerAddress(1, "Bangalore"),
                                new CustomerAddress(1, "Mumbai")))

        );

//
//        List<List<CustomerAddress>> allAddress = customers
//                .stream()
//                .map(x -> x.getAddresses())
//                .collect(Collectors.toList());

        List<CustomerAddress> allAddress = customers
                .stream()
                .flatMap(x -> x.getAddresses().stream())
                .collect(Collectors.toList());

        System.out.println(allAddress);

        List<String> allCities = customers
                .stream()
                .flatMap(x -> x.getAddresses().stream())
//                .map(x -> x.getLine1())
                .map(CustomerAddress::getLine1)
                .sorted()
                .distinct()
                .collect(Collectors.toList());

        System.out.println(allCities);


    }
}
