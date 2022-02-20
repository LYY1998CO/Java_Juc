package com.sycn;
class Share{
    private int num=0;
    public synchronized void incr() throws InterruptedException
    {
        while (num!=0)
        {
            this.wait();
        }
        num++;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        this.notifyAll();
    }
    public synchronized void decr() throws InterruptedException {
        while (num!=1)
        {
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"::"+num);
        this.notifyAll();
    }
}
public class ThreadDemo1 {
    public static void main(String[] args) {
        Share share = new Share();

        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"AA").start();

        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"BB").start();


        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    share.incr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"CC").start();

        new Thread(()->{
            for (int i = 0; i <=10 ; i++) {
                try {
                    share.decr();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"DD").start();
    }
}
