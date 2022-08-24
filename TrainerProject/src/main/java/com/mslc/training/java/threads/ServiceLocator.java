package com.mslc.training.java.threads;


import java.util.Vector;

/**
 * REDIS
 * MemCache
 */
public class ServiceLocator {


    static {
        System.out.println("ServiceLocator Class is loaded");
    }


    public static void demo() {


    }

    private ServiceLocator() {

        /**
         * Set the complex state of ServiceLocator
         *
         */

    }

    public static ServiceLocator getInstance() {

        return ServiceLocatorHolder.me;
    }

    private static class ServiceLocatorHolder {
        static {
            System.out.println("ServiceLocatorHolder Class loaded.....");
        }

        private static ServiceLocator me = new ServiceLocator();

    }
}
