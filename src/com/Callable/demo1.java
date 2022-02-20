package com.Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

//比较两个接口
class MyThread1 implements Runnable{
    @Override
    public void run() {
    }
}
class MyThread2 implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName()+" come on in Callable");
        return 200;
    }
}
public class demo1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new Thread(new MyThread1(),"AA").start();
        //FutureTask
        FutureTask<Integer> futureTask1=new FutureTask<>(new MyThread2());
        //拉姆达表达式实现
        FutureTask<Integer> futureTask2=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName()+" come on in Callable");
            return 1024;
        });
        new Thread(futureTask2,"BB").start();
        new Thread(futureTask1,"CC").start();
//        while (!futureTask2.isDone()){
//            System.out.println("wait....");
//        }
        System.out.println(futureTask2.get());
        System.out.println(futureTask1.get());
        System.out.println(Thread.currentThread().getName()+" come over");
    }
}
