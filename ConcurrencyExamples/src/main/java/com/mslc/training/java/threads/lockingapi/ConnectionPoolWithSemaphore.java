package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

public class ConnectionPoolWithSemaphore {


    Semaphore semaphore = null;

    private Object[] pool = null;
    //    private boolean[] used = null;
    private AtomicBoolean[] used = null;
    private int size;

    public ConnectionPoolWithSemaphore(int size) {

        this.size = size;
        pool = new Object[size];
        used = new AtomicBoolean[size];
        semaphore = new Semaphore(size);
        this.initialize();
    }

    private void initialize() {
        for (int i = 0; i < size; i++) {
            pool[i] = new Object();
            used[i] = new AtomicBoolean(false);
        }
    }

    public Object getConnection() {
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Object connectionThatIsNotInUse = null;
        for (int i = 0; i < size; i++) {

//            synchronized (used) {
//                if (!used[i]) {
//                    used[i] = true;
//
            used[i].compareAndSet(false, true);
            connectionThatIsNotInUse = pool[i];
            break;

//            }
        }
        return connectionThatIsNotInUse;
    }

    public void closeConnection(Object connection) {

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (pool[i] == connection) {
                found = true;
//                synchronized (used) {
//                    used[i] = false;
//                }
                used[i].set(false);
                semaphore.release();
                break;
            }
        }
        if (!found) {
            throw new RuntimeException("The connection object that you have passed was never in the pool");
        }
    }


}
