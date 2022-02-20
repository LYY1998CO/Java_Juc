package com.Lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Share{
    private int num=0;
    Lock lock=new ReentrantLock();
    private Condition condition=lock.newCondition();
    public void incr() throws InterruptedException {
        lock.lock();
        try {
            while (num!=0){
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"::"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void decr() throws InterruptedException {
        lock.lock();
        try {
            while (num!=1){
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"::"+num);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
public class ThreadDemo2 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();



        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();



        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();


        new Thread(()->{
            for (int i = 1; i <=10 ; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
