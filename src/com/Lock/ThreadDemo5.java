package com.Lock;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

//集合中线程的不安全性
public class ThreadDemo5 {
    public static void main(String[] args) {
        //演示hashset
//        Set<String> set=new HashSet<String>();
//        Set set=new CopyOnWriteArraySet();
//        for (int i = 0; i < 30; i++) {
//            new Thread(()->{
//                set.add(UUID.randomUUID().toString().substring(0,8));
//                System.out.println(set);
//            },String.valueOf(i)).start();
//        }
        //演示hashmap
//        Map<String,String> map=new HashMap();
        Map<String,String>map=new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++) {
            String key=String.valueOf(i);
            new Thread(()->{
                map.put(key,UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
