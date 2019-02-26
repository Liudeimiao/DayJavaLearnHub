package com.java.thread.chapter01;

/**
 * @Author: Ldm
 * @Date: 2019/2/26 15:54
 *
 * 创建线程-常用的两种方式。
 *
 * Thread 和 Runnable 的相同点：都是“多线程的实现方式”。
 * Thread 和 Runnable 的不同点：
 *
 * Thread 是类，而Runnable是接口；Thread本身是实现了Runnable接口的类。
 * 我们知道“一个类只能有一个父类，但是却能实现多个接口”，因此Runnable具有更好的扩展性。
 *
 * 此外，Runnable还可以用于“资源的共享”。即，多个线程都是基于某一个Runnable对象建立的，
 * 它们会共享Runnable对象上的资源。
 *
 * 通常，建议通过“Runnable”实现多线程！
 *
 */
public class MyThread extends Thread{

    private int ticket=10;
    public void run(){
        for(int i=0;i<20;i++){
            if(this.ticket>0){
                System.out.println(this.getName()+" 卖票：ticket"+this.ticket--);
            }
        }
    }

}

 class ThreadTest {
    public static void main(String[] args) {
        // 启动3个线程t1,t2,t3；每个线程各卖10张票！
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        MyThread t3=new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

