package com;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
class Share{
    private int flag=1;
    Lock lock=new ReentrantLock();
    Condition c1=lock.newCondition();
    Condition c2=lock.newCondition();
    Condition c3=lock.newCondition();
    public void print5(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=1){
                c1.await();
            }
            //干活操作
            for (int i = 1; i <=5; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag=2;
            c2.signal();
        }
        finally {
            lock.unlock();
        }
    }
    public void print10(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=2){
                c2.await();
            }
            //干活操作
            for (int i = 1; i <=10; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag=3;
            c3.signal();
        }
        finally {
            lock.unlock();
        }
    }
    public void print15(int loop) throws InterruptedException {
        lock.lock();
        try {
            while (flag!=3){
                c3.await();
            }
            //干活操作
            for (int i = 1; i <=15; i++) {
                System.out.println(Thread.currentThread().getName()+"::"+i+"轮数"+loop);
            }
            flag=1;
            c1.signal();
        }
        finally {
            lock.unlock();
        }
    }
}
public class ThreadDemo3 {
    public static void main(String[] args) {
        Share share = new Share();
        new Thread(()->{
            for (int i = 1; i <=10; i++) {
                try {
                    share.print5(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();


        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    share.print10(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();


        new Thread(()->{
            for (int i = 1; i <= 10; i++) {
                try {
                    share.print15(i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();
    }
}
