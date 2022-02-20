package com.Lock;

import java.util.concurrent.TimeUnit;
public class Phone {
    public  synchronized void sendMail()throws Exception{
        System.out.println("sendMail");
    }
    public static synchronized void sendMEM()throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendMEM");
    }
    public void getHello(){
        System.out.println("getHello");
    }
}
