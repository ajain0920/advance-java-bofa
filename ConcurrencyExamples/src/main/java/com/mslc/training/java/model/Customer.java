package com.mslc.training.java.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {


    private Integer id;
    private String name;
    private List<CustomerAddress> addresses;


    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }


//    private City city;
//    //    private static int totalCustomers = 5000;
//    public static Integer totalCustomers = 5000;

}
