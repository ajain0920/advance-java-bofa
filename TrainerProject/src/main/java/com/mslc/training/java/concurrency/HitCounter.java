package com.mslc.training.java.concurrency;

public class HitCounter {


    private static int commonCount;
//    private static Object lock = new Object();


    /**
     * The object monitor of object of class Class
     */
    public static void incrementCommonCount() {
        /**
         * 5/7 lines
         */

        synchronized (HitCounter.class) {
            commonCount++;
        }

    }


    private int httpCounter;
    private int httpsCounter;

    Object httpLock = new Object();
    Object httpsLock = new Object();

    public void incrementHttpCount() {

        synchronized (httpLock) {
            httpCounter++;
        }


    }

    public void incrementHttpsCount() {

        synchronized (httpsLock) {
            httpsCounter++;
        }

    }
}
