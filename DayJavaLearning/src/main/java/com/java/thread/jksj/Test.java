package com.java.thread.jksj;

/**
 * @Author: Ldm
 *
 * 线程 可见性问题
 *
 */
public class Test {

    private static  long count = 0;

    //累加
    private synchronized   void add10k(){
        int idx = 0;

        while (idx++ <10000){
            count += 1;
        }
    }
    //累加操作
    public  static long calc() throws InterruptedException {
        final  Test test = new Test();
        //创建两个线程 执行 add 操作
        Thread th1 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.add10k();
            }
        });

        Thread th2 = new Thread(new Runnable() {
            @Override
            public void run() {
                test.add10k();
            }
        });

        // 启动两个线程
        //等待两个线程结束
        th1.start();
        th2.start();
        th1.join();
        th2.join();

        //返回类累加值
        return count;
    }


    public static void main(String[] args) throws InterruptedException {
        long count = Test.calc();
        System.out.println("两次线程累加值： "+ count);
    }



}
