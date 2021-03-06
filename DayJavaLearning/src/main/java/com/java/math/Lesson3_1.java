package com.java.math;

public class Lesson3_1 {
    /** 迭代法
     * @Description: 算算舍罕王给了多少粒麦子
     * @param grid- 放到第几格
     * @return long- 麦粒的总数
     */

    public static long getNumberOfWheat(int grid) {

        long sum = 0;      // 麦粒总数
        long numberOfWheatInGrid = 0;  // 当前格子里麦粒的数量

        numberOfWheatInGrid = 1;  // 第一个格子里麦粒的数量
        sum += numberOfWheatInGrid;

        for (int i = 2; i <= grid; i ++) {
            numberOfWheatInGrid *= 2;   // 当前格子里麦粒的数量是前一格的 2 倍
            sum += numberOfWheatInGrid;   // 累计麦粒总数
        }

        System.out.println("国王要给的麦粒： "+ sum);
        return sum;

    }

    /*public static void main(String[] args) {

        getNumberOfWheat(63);
    }*/

    public static void main(String[] args) {

        int grid = 63;
        long start, end = 0;
        start = System.currentTimeMillis();
        System.out.println(String.format(" 舍罕王给了这么多粒：%d", Lesson3_1.getNumberOfWheat(grid)));
        end = System.currentTimeMillis();
        System.out.println(String.format(" 耗时 %d 毫秒 ", (end - start)));

        start = System.currentTimeMillis();
        System.out.println(String.format(" 舍罕王给了这么多粒：%d", (long)(Math.pow(2, grid)) - 1));
        end = System.currentTimeMillis();
        System.out.println(String.format(" 耗时 %d 毫秒 ", (end - start)));

    }

}
