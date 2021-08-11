package edu.ncu.dongli.leetcode.exercise.primary.string;

/**
 * 问题：整数反转
 * 描述：
 *      给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *      如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31−1] ，就返回 0。
 *      假设环境不允许存储 64 位整数（有符号或无符号）。
 */
public class ReverseInteger {
    /**
     * 按位反转
     * @param x
     * @return
     */
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            //获取每位上的值t
            int t = x%10;
            int newRes = res*10 + t;
            //如果数字溢出，直接返回0
            if ((newRes - t)/10 != res)
                return 0;
            res = newRes;
            x = x/10;
        }
        return res;
    }
    public static void main(String[] args) {
        ReverseInteger reverseInteger=new ReverseInteger();
        int res=reverseInteger.reverse(1003);
        System.out.println(res);
    }
}
