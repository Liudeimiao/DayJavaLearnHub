package com.java.thread.chapter03;

/**
 * @Author: Ldm
 * @Date: 2019/3/13 10:42
 */
public class MyThread extends Thread{

    public MyThread(String name) {
        super(name);
    }

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

class Demo1_2 {
    public static void main(String[] args) {
        Thread t1 = new MyThread("t1");  // 新建“线程t1”
        Thread t2 = new MyThread("t2");  // 新建“线程t2”
        t1.start();                          // 启动“线程t1”
        t2.start();                          // 启动“线程t2”
    }
}

/*
*
* 结果说明：
如果这个结果一点也不令你感到惊讶，那么我相信你对synchronized和this的认识已经比较深刻了。
否则的话，请继续阅读这里的分析。
synchronized(this)中的this是指“当前的类对象”，即synchronized(this)所在的类对应的当前对象。
它的作用是获取“当前对象的同步锁”。

mark1:
对于Demo1_2中，synchronized(this)中的this代表的是MyThread对象，
而t1和t2是两个不同的MyThread对象，
因此t1和t2在执行synchronized(this)时，获取的是不同对象的同步锁。

mark2
对于Demo1_1对而言，synchronized(this)中的this代表的是MyRunable对象；
t1和t2共同一个MyRunable对象，因此，一个线程获取了对象的同步锁，会造成另外一个线程等待。
* */


