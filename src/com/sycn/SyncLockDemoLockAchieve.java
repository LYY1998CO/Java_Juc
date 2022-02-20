package com.sycn;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//可重入锁
public class SyncLockDemoLockAchieve {
    public synchronized void add(){
        add();
    }
    public static void main(String[] args) {
        //lock演示可重入锁
        Lock lock = new ReentrantLock();
        new Thread(()->{
            try {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+"外层");
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+"内层");
                }
                finally {
                    lock.unlock();
                }
            }finally {
                lock.unlock();
            }
        },"AA").start();
        new Thread(()->{
            lock.lock();
            System.out.println("aaaa");
            lock.unlock();
        },"BB").start();
    }
}
