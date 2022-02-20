package com.juc;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    private static final int NUMBER=7;
    public static void main(String[] args) {
        CyclicBarrier cCyclicBarrier = new CyclicBarrier(
                NUMBER,()->{ System.out.println("集齐七颗龙珠，召唤神龙"); }
        );
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                try {
                    System.out.println(Thread.currentThread().getName()+" 星龙珠被收集到了");
                    cCyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
