package com.java.math;

import java.util.Scanner;

/**
 * @Author: Ldm
 * @Date: 2019/4/8 17:20
 */
public class Lesson_1 {

    public static String decimal2Binary(int decimal) {
        // 负数的话,先换成正数然后取反再加1,再递归调用本函数
        if (decimal < 0) {
            int reverseNumber = ((decimal * -1) ^ Integer.MAX_VALUE) + 1;
            return decimal2Binary (reverseNumber);
        }
        StringBuilder sb = new StringBuilder();
        while (decimal > 0) {
            // 跟0x0001 按位与,求得最低位的值
            String lastNumber = String.valueOf(decimal & 1);
            // 插入到字符串的最前面(这样才是原始的顺序)
            sb.insert(0, lastNumber);
            // 算术右移
            decimal = decimal >> 1;
        }
        System.out.println(decimal+"  转为2进制数："+sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        decimal2Binary(3);
    }

}


