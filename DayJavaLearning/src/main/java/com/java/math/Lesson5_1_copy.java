package com.java.math;

/**
 * @Author: Ldm
 * @Date: 2019/4/6 11:30
 */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Lesson5_1_copy {

    //赏金票面
    public  static  long[] rewards = {1,2};


    public  static  final  Set<ArrayList<Long>> listSet = new HashSet<>();
    /***
     *
     * @param totalRewards  赏金总额
     * @param result  赏金组成方式 数组
     */
    public static void get(long totalRewards,ArrayList<Long> result){



        // 终止条件
        if (totalRewards==0){
            System.out.println("正确的值："+result);
            listSet.add(result);
            return;

        }else if (totalRewards<0){
            System.out.println("错误的值："+result);
            //当 赏金 totalRewards-rewards[i] 小于 0 的时候，要return
            //否则一直 网get(); 方法里面传参，压栈，出现
            // java.lang.StackOverflowError 栈溢出异常。
            return;
        }else {
            for (int i = 0;i<rewards.length;i++){
                // 由于有 4 种情况，需要 clone 当前的解并传入被调用的函数
                ArrayList<Long> newResult = (ArrayList<Long>) (result.clone());
                //加入[1,,1.....]
                newResult.add(rewards[i]);
                //调用方法，去对比终止条件，totalRewards ==0 ，去输出。
                //如果totalRewards <0 ,同样return 掉。否则栈溢出。
                get((totalRewards-rewards[i]),newResult);
            }
        }


    }

    public static void main(String[] args) {
        long totalRewards = 3;
        get(totalRewards,new ArrayList<Long>());
        System.out.println("排列组合种类："+listSet.size());
    }

}


