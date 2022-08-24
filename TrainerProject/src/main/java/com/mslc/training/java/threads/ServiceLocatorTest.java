package com.mslc.training.java.threads;


/**
 * Each and every Object has reference to its Class
 * Each and every Class has a reference to the ClassLoader that loaded it
 * ClassLoader instance has reference to all the classes that it has loaded
 *
 *
 *
 */
public class ServiceLocatorTest {

    public static void main(String[] args) {


        ServiceLocator.demo();
        ServiceLocator.demo();
        ServiceLocator.demo();
        ServiceLocator.demo();
        ServiceLocator.demo();
        ServiceLocator.demo();
        ServiceLocator serviceLocator1 = ServiceLocator.getInstance();
        ServiceLocator serviceLocator2 = ServiceLocator.getInstance();
        ServiceLocator serviceLocator3 = ServiceLocator.getInstance();
        ServiceLocator serviceLocator4 = ServiceLocator.getInstance();
        ServiceLocator serviceLocator5 = ServiceLocator.getInstance();


        System.out.println(serviceLocator1);
        System.out.println(serviceLocator2);
        System.out.println(serviceLocator3);
        System.out.println(serviceLocator4);
        System.out.println(serviceLocator5);



//        ServiceLocator serviceLocator = ServiceLocator.getInstance();
//        System.out.println(serviceLocator);
//
//        ServiceLocator serviceLocator1 = ServiceLocator.getInstance();
//        System.out.println(serviceLocator1);
//
//        ServiceLocator serviceLocator3 = ServiceLocator.getInstance();
//        System.out.println(serviceLocator3);




    }
}
