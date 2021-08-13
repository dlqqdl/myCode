package edu.ncu.dongli.leetcode.exercise.primary.string;

/**
 * 问题：字符串转换整数 (atoi)
 * 请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,231−1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231,大于 231− 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 * s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class Atoi {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        int index = 0;
        // 先去除空格
        while (index < length && chars[index] == ' ')
            index++;
        // 极端情况 "  " 和""
        if(index >= length)
            return 0;
        // 再判断符号
        int sign = 1;
        if(chars[index] == '-' || chars[index] == '+'){
            if(chars[index] == '-')
                sign = -1;
            index++;
        }
        int result = 0;
        int temp = 0;
        while (index < length){
            int num = chars[index] - '0';
            if(num > 9 || num < 0)
                break;
            temp = result;
            result = result * 10 + num;
            //越界后，数值和期望数值发生变化，取余再除10获取原始值，比对判断
            if(result/10 !=temp){
                if(sign > 0)
                    return Integer.MAX_VALUE;
                else
                    return Integer.MIN_VALUE;
            }
            index++;
        }
        return result*sign;
    }

    public static void main(String[] args) {
        Atoi atoi=new Atoi();
        System.out.println(atoi.myAtoi("-91283472332"));
        System.out.println(atoi.myAtoi("words and 987"));
    }
}
