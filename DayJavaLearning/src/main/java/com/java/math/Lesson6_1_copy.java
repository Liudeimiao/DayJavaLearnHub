package com.java.math;

/**
 * @Author: Ldm
 * @Date: 2019/4/6 16:43
 */
import java.util.Arrays;

public class Lesson6_1_copy {

    /***
     *  使用函数的递归（嵌套）调用，实现数组排序 从小到大
     * @param to_sort
     * @return
     */
    public static int[] merge_sort(int[] to_sort){

        if (to_sort ==null){ return  new int[0];}//空验证

        //如果分解到只有一个数，返回这个数
        if (to_sort.length==1) return to_sort;

        // 将数组分解成左右两半
        int mid = to_sort.length/2;
        int[] left = Arrays.copyOfRange(to_sort,0,mid);
        int[] right = Arrays.copyOfRange(to_sort,mid,to_sort.length);

        // 嵌套调用，对两半分别进行排序
        left = merge_sort(left);
        right = merge_sort(right);

        // 合并排序后的两半
        int[] merged = merge(left,right);

        return merged;

    }

    /**
     * @Description: 合并两个已经排序完毕的数组（从小到大）
     * @param a- 第一个数组，b- 第二个数组
     * @return int[]- 合并后的数组
     */

    public static int[] merge(int[] a,int[] b){

        //空验证
        if (a==null) return  new  int[0];
        if (b==null) return  new  int[0];

        //合并的数组大小
        int[] merge_one = new int[a.length+b.length];

        // 轮流从两个数组中取出较小的值，放入合并后的数组中
        int mi = 0, ai=0,bi=0;
        while (ai<a.length && bi<b.length){

            if (a[ai] <= b[bi]){
                merge_one[mi] = a[ai];
                ai++;
            }else {
                merge_one[mi] = b[bi];
                bi++;
            }
            mi++;
        }

        // 将某个数组内剩余的数字放入合并后的数组中
        if (ai<a.length){
            for (int i = ai;i<a.length;i++){
                merge_one[mi] = a[i];
                mi++;
            }
        }else {
            for (int i = bi;i<b.length;i++){
                merge_one[mi] = b[i];
                mi++;
            }
        }

        return  merge_one;
    }


    public static void main(String[] args) {
        int[] test = {5,4,3,2,1};

        int[] sorted = merge_sort(test);
        for (int i =0;i<sorted.length;i++){
            System.out.println(sorted[i]);
        }


    }
}
