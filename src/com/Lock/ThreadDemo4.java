package com.Lock;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//集合中线程的不安全性
public class ThreadDemo4 {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
        //vector解决方法
//        List<String> list = new Vector<>();
        //通过collections工具类来解决线程不安全的问题
//        List<String> list= Collections.synchronizedList(new ArrayList<>());
        //利用JUC包解决不安全的问题
        //CopyOnWriteArrayList写时复制技术
        List<String> list=new CopyOnWriteArrayList<>();
        for (int i = 0; i <30 ; i++) {
           new Thread(()->{
               //给集合添加值
               list.add(UUID.randomUUID().toString().substring(0,8));
               //获取集合中的元素
               System.out.println(list);
           },String.valueOf(i)).start();
        }
    }
}
