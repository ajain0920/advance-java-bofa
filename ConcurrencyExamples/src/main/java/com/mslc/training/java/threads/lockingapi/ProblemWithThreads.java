package com.mslc.training.java.threads.lockingapi;

import java.util.List;

public class ProblemWithThreads {


    public static void main(String[] args) {


        List<Object> commonDataStructure;

        new Thread() {
            @Override
            public void run() {

                /**
                 *
                 * Invoke API 1
                 *
                 *
                 */

            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                /**
                 * Invoke API 2
                 *
                 */
            }
        }.start();


    }
}
