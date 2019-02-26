package com.java.thread.chapter01;

/**
 * @Author: Ldm
 * @Date: 2019/2/26 15:57
 */
public class MyThead_CP  extends Thread{

    private int ticket=10;// 共10张票

    public  void  run(){
        for (int i=0;i<20;i++){

            if (this.ticket>0){//
                System.out.println(this.getName()+" 卖票 ticket "+ this.ticket--);
            }

        }
    }

}

class MyTheadTest01{
    public static void main(String[] args) {

        /***
         * 结果说明：
         * (01) MyThread继承于Thread，它是自定义个线程。每个MyThread都会卖出10张票。
         * (02) 主线程main创建并启动3个MyThread子线程。每个子线程都各自卖出了10张票。
         */

        //启动三个线程 各买 10张票
        MyThead_CP t1 =new MyThead_CP();
        MyThead_CP t2 =new MyThead_CP();
        MyThead_CP t3 =new MyThead_CP();

        t1.start();
        t2.start();
        t3.start();


        // 不要直接调用 run 方法，线程回跑两次
        /*t1.run();
        t2.run();
        t3.run();*/
    }
}