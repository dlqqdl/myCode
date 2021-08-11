package edu.ncu.dongli.leetcode.exercise.primary.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 问题描述：
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 示例：
 *      输入：digits = [1,2,3]
 *      输出：[1,2,4]
 *      解释：输入数组表示数字 123。
 *
 *      输入：digits = [4,3,2,1]
 *      输出：[4,3,2,2]
 *      解释：输入数组表示数字 4321。
 */
public class PlusOne {
    public int[] plusOne_Normal(int[] digits) {
        //从低位开始
        for (int i=digits.length-1;i>=0;i--){
            if (digits[i]==9){
                digits[i]=0;
            }else if (digits[i]!=9){
                digits[i]+=1;
                break;
            }
        }
        //全部产生了进位，100000.....的样子
        if (digits[0]==0){
            int[] num=new int[digits.length+1];
            num[0]=1;
            for (int i=1;i<num.length;i++)
                num[i]=digits[i-1];
            return num;
        }
        return digits;

    }

    public static void main(String[] args) {
        PlusOne plusOne=new PlusOne();
        int[] res=plusOne.plusOne_Normal(new int[]{1,2,3,4});
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
        res=plusOne.plusOne_Normal(new int[]{1,2,3,9});
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
        res=plusOne.plusOne_Normal(new int[]{9,9,3,9});
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
        res=plusOne.plusOne_Normal(new int[]{9,9,9,9});
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();

    }
}
