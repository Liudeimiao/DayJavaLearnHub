package com.java.thread.chapter03;

/**
 * @Author: Ldm
 * @Date: 2019/3/13 10:36
 */

/***
 * 1. synchronized原理
 *
 * 1、在java中，每一个对象有且仅有一个同步锁。这也意味着，同步锁是依赖于对象而存在。
 * 2、当我们调用某对象的synchronized方法时，就获取了该对象的同步锁。例如，synchronized(obj)就获取了“obj这个对象”的同步锁。
 *
 * 3、不同线程对同步锁的访问是互斥的。也就是说，某时间点，对象的同步锁只能被一个线程获取到！通过同步锁，我们就能在多线程中，
 * 实现对“对象/方法”的互斥访问。 例如，现在有两个线程A和线程B，它们都会访问“对象obj的同步锁”。
 * 假设，在某一时刻，线程A获取到“obj的同步锁”并在执行一些操作；而此时，线程B也企图获取“obj的同步锁”
 * —— 线程B会获取失败，它必须等待，直到线程A释放了“该对象的同步锁”之后线程B才能获取到“obj的同步锁”从而才可以运行。
 */

public class MyRunable implements Runnable {
    @Override
    public void run() {
        synchronized(this) {
            try {
                for (int i = 0; i < 5; i++) {
                    Thread.sleep(100); // 休眠100ms
                    System.out.println(Thread.currentThread().getName() + " loop " + i);
                }
            } catch (InterruptedException ie) {
            }
        }
    }
}



class Demo1_1 {
    public static void main(String[] args) {
        Runnable demo = new MyRunable();     // 新建“Runnable对象”

        Thread t1 = new Thread(demo, "t1");  // 新建“线程t1”, t1是基于demo这个Runnable对象
        Thread t2 = new Thread(demo, "t2");  // 新建“线程t2”, t2是基于demo这个Runnable对象
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}

/*
* 结果说明：
run()方法中存在“synchronized(this)代码块”，而且t1和t2都是基于"demo这个Runnable对象"创建的线程。
这就意味着，我们可以将synchronized(this)中的this看作是“demo这个Runnable对象”；
因此，线程t1和t2共享“demo对象的同步锁”。所以，当一个线程运行的时候，另外一个线程必须等待“运行线程”释放“demo的同步锁”之后才能运行。
*
* 一个对象只有一把锁，那个线程先访问对象就独占CPU执行
* */