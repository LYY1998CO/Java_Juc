package com.sycn;
//资源类
class piao{
    private int number=30;
    public synchronized void sale(){
        if (number>0){
            System.out.println(Thread.currentThread().getName()+":卖出:"+(number--)+"剩下:"+number);
        }
    }
}
public class Ticket {
    public static void main(String[] args) {
        piao p = new piao();
        //创建线程
        Thread aa = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    p.sale();
                }
            }
        }, "aa");
        aa.start();


        Thread bb = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    p.sale();
                }
            }
        }, "bb");
        bb.start();


        Thread cc = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <40 ; i++) {
                    p.sale();
                }
            }
        }, "cc");
        cc.start();
    }
}
