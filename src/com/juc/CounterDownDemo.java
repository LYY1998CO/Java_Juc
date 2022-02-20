package com.juc;

import java.util.concurrent.CountDownLatch;
/*
演示CounterDownLatch
 */
public class CounterDownDemo {
    public static void main(String[] args) throws InterruptedException {
        //创建CounterDownLatch
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开教室");
                countDownLatch.countDown();//减1操作
            },String.valueOf(i)).start();
        }
        /*
         */
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"班长锁门走人");
    }
}
