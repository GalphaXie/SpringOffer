package com.company.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ServiceLockInterruptibly {

    public ReentrantLock lock = new ReentrantLock();


    public void waitMethodLock(){
        try {
            lock.lock();
            for(int i=0;i<Integer.MAX_VALUE/10;i++){

            }
        }
        finally {
            lock.unlock();
        }
    }

    public void waitMethodLockInterruptibly(){
        try {
            lock.lockInterruptibly(); //这里是非抢占式的，只有等上一个线程释放锁之后，该方法才能去获取锁
            System.out.println("lock begin "+Thread.currentThread().getName());
            for (int i = 0; i < Integer.MAX_VALUE / 10; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println("lock end "+Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
