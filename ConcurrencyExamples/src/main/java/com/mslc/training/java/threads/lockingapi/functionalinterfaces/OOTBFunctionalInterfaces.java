package com.mslc.training.java.threads.lockingapi.functionalinterfaces;

import com.mslc.training.java.model.Customer;

import java.util.function.Function;
import java.util.function.Supplier;

public class OOTBFunctionalInterfaces {


    public static void someHigherOrderFunction(Function<Integer, Integer> adder) {
        /**
         *
         *
         */
        System.out.println(adder.apply(30));


    }

    public static void main(String[] args) {

//
//        java.util.function.Function<String, Integer> f = new Function<String, Integer>() {
//            @Override
//            public Integer apply(String o) {
//                return 2;
//            }
//        };
//        java.util.function.Function<String, Integer> f = x -> {
//            /**
//             *  2/2 lines of code to calculate the value
//             */
//            return 2;
//        };
//        java.util.function.Function<Integer, Integer> f = x -> {
//            /**
//             *
//             *
//             */
//            return x + 10;
//        };
        someHigherOrderFunction(OOTBFunctionalInterfaces::commonAdder);

        OOTBFunctionalInterfaces ootbFunctionalInterfaces = new OOTBFunctionalInterfaces();
        someHigherOrderFunction(ootbFunctionalInterfaces::theCommonAdder);


//        System.out.println(f.apply(20));


        java.util.function.BiFunction<String, String, Integer> f2 = (x, y) -> x.length() + y.length();
        java.util.function.IntFunction<String> f3 = x -> "The value :  " + x;

        java.util.function.Consumer<String> f4 = x -> {
            System.out.println("The value received is : " + x);
        };

        java.util.function.BiConsumer<String, String> f5 = (x, y) -> {
        };

        java.util.function.Predicate<String> f6 = x -> x.equals("BoA");
        java.util.function.BiPredicate<String, String> f7 = (x, y) -> x.equals(y);


        java.util.function.Supplier<String> f8 = () -> "BoA";
        java.util.function.Supplier<Customer> customerSupplier = () -> {
            Customer c = new Customer();
            c.setId(101);
            c.setName("BoA");
            return c;
        };

        Supplier<Customer> customerSupplier1 = Customer::new;


        java.util.function.BooleanSupplier f9 = () -> true;

        java.util.function.DoubleConsumer f10 = x -> {
            System.out.println("Double value is : " + x);
        };


    }

    public static Integer commonAdder(Integer parameter) {
        /**
         *
         *
         */
        return parameter + 10;
    }


    public Integer theCommonAdder(Integer parameter) {
        /**
         *
         *
         */
        return parameter + 10;
    }
}
