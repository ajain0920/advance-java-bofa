package com.mslc.training.java.threads.lockingapi.functionalinterfaces;

public class FunctionInterfaceDemo {


    public static void main(String[] args) {
//
//        TaxCalculator taxCalculator = new TaxCalculator() {
//            @Override
//            public int calculateTax(String state) {
//                if (state.equals("Maha"))
//                    return 10;
//                else {
//                    return 8;
//                }
//            }
//        };

//        TaxCalculator taxCalculator1 = (state) -> {
//            if (state.equals("Maha"))
//                return 10;
//            else {
//                return 8;
//            }
//        };

        TaxCalculator taxCalculator = (x, y) -> (x.equals("Maha") ? 10 : 8) + y;

        generateInvoice(taxCalculator);

        Runnable r = () -> {
            System.out.println("This is the task");
        };



    }


    /**
     *
     * Higher Order Functions.
     *
     *
     * @param taxCalculator
     */
    public static void generateInvoice(TaxCalculator taxCalculator) {

        int tax = taxCalculator.calculateTax("Maha", 10);
        System.out.println("The tax is :  " + tax);
        /**
         *
         *
         */
    }
}


/**
 * Functionality
 */
@FunctionalInterface
interface TaxCalculator {

    int calculateTax(String state, int centralTaxToAdd);

    public default int calculateDefaultTax(Integer stateCode) {

        return 15;
    }

    public static void printAllTaxes() {
        ///
    }


}
