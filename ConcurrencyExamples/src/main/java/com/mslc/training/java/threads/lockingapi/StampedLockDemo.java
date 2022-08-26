package com.mslc.training.java.threads.lockingapi;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {


}


class MyDataStructureSL {


    private int x = 5;
    private int y = 5;
    StampedLock sl = new StampedLock();


    public void demonstrateWriteLock() {
        long stamp = sl.writeLock();
        try {
            x = 10;
            y = 5;

        } finally {
            sl.unlock(stamp);
        }
    }

    public void demonstrateOptimisticRead() {

        long stamp = sl.tryOptimisticRead();
        int currentX = x;
        int currentY = y;
        boolean success = sl.validate(stamp);
        if (success) System.out.println(currentX + " -- " + currentY);
        else {
            long rStamp = sl.readLock();
            System.out.println("Read Lock Acquired...");

            try {

            } finally {
                sl.unlock(rStamp);
            }

        }


    }


}
