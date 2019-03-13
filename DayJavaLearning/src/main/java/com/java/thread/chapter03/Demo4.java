package com.java.thread.chapter03;

/**
 * @Author: Ldm
 * @Date: 2019/3/13 11:10
 */
public class Demo4 {


    //修饰方法
    public synchronized void synMethod() {
        for(int i=0; i<1000000; i++)
            ;
    }

    //修饰代码块
    public void synBlock() {
        synchronized( this ) {
            for(int i=0; i<1000000; i++)
                ;
        }
    }

    public static void main(String[] args) {
        Demo4 demo = new Demo4();

        long start, diff;
        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synMethod();                                // 调用“synchronized方法”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synMethod() : "+ diff);

        start = System.currentTimeMillis();                // 获取当前时间(millis)
        demo.synBlock();                                // 调用“synchronized方法块”
        diff = System.currentTimeMillis() - start;        // 获取“时间差值”
        System.out.println("synBlock()  : "+ diff);
    }

}

/*
* synchronized代码块中的this是指当前对象。也可以将this替换成其他对象，
* 例如将this替换成obj，则foo2()在执行synchronized(obj)时就获取的是obj的同步锁。


synchronized代码块可以更精确的控制冲突限制访问区域，有时候表现更高效率。下
* */


