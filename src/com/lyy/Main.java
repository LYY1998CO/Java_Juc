package com.lyy;

public class Main {
    public static void main(String[] args) {
        Thread aa = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "::" + Thread.currentThread().isDaemon());
            while (true) {

            }

        }, "aa");
        //设置为守护线程（true代表为守护线程，FALSE代表用户线程）
        aa.setDaemon(true);
        aa.start();
        System.out.println(Thread.currentThread().getName()+":over");
    }
}
