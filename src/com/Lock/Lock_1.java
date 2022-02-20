package com.Lock;
/*
锁的8种情况:
 1.标准访问，先打印短信还是邮件:
 sendMEM
 sendMail
 2.停留4s在短信方法中，先打印短信还是邮件:
 sendMEM
 sendMail
 3.新增普通方法hello，先打印短信还是hello:
 getHello
 sendMEM
 4.现在两部手机，先打印短信还是邮件:
 sendMail
 sendMEM
 5.两个静态同步方法，1部手机，先打印短信还是邮件:
 sendMEM
 sendMail
 6.两个静态同步方法，2部手机，先打印短信还是邮件:
 sendMEM
 sendMail
 7.1个静态同步方法，1个普通同步方法，1部手机，先打印短信还是邮件:
 sendMail
 sendMEM
 8.1个静态同步方法，1个普通同步方法，2部手机，先打印短信还是邮件:
 sendMail
 sendMEM
 */
public class Lock_1 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            try {
            phone.sendMEM();
        } catch (Exception e){
            e.printStackTrace();
        }
        },"AA").start();


        Thread.sleep(100);



        new Thread(()->{
            try{
                phone2.sendMail();
//                phone.sendMail();
//                phone.getHello();
            }
            catch (Exception e){
                e.printStackTrace();
            }
        },"BB").start();
    }
}
