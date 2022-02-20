package com.sycn;
//可重入锁
public class SyncLockDemo {
//    public synchronized void add(){
//        add();
//    }
    public static void main(String[] args) {
//        SyncLockDemo demo = new SyncLockDemo();
//        demo.add();
        Object o = new Object();
        new Thread(()->{
            synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"外层");
                synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"中层");
                    synchronized (o){
                        System.out.println(Thread.currentThread().getName()+"内层");
                    }
                }
            }
        },"AA").start();
    }
}
