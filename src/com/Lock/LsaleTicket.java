package com.Lock;

import java.util.concurrent.locks.ReentrantLock;

//资源类
class Ticket{
    //使用lock来实现买票的操作
    private int number=30;
    private final ReentrantLock lock=new ReentrantLock();
    public void sale(){
        //上锁
        lock.lock();
        //具体实现逻辑
        try{
            if (number>0){
            System.out.println(Thread.currentThread().getName()+":卖出:"+(number--)+"剩下:"+number);
        }
        }finally {
            //解锁
            lock.unlock();
        }
    }
}
public class LsaleTicket {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();
        //创建一个线程
        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                ticket.sale();
            }
        },"aa").start();
        //创建一个线程
        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                ticket.sale();
            }
        },"bb").start();
        //创建一个线程
        new Thread(()->{
            for (int i = 0; i <40 ; i++) {
                ticket.sale();
            }
        },"cc").start();
    }
}
