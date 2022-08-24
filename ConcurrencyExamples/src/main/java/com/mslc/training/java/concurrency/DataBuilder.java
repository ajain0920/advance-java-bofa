package com.mslc.training.java.concurrency;

public class DataBuilder {

    private Object[] data;

    volatile boolean initialized = false;


    public Object[] buildData() {


        while (!initialized) {
            Thread.currentThread().yield();
        }

        //
        if (!initialized) {
            /// write code to initialize the data

            this.initialized = true;
        } else {
            return data;
        }

        return null;

    }


}
