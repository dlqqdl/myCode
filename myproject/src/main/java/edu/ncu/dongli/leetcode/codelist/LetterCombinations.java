package edu.ncu.dongli.leetcode.codelist;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同:输入法的九键）。注意 1 不对应任何字母。
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 */
public class LetterCombinations {

    String[] strings=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};//2-9的映射
    StringBuffer buffer=new StringBuffer();
    List<String> list=new ArrayList<>();//结果保存
    public List<String> letterCombinations(String digits) {
        if (digits==null||digits.length()==0)
            return list;
        back(digits,0);
        return list;
    }

    /**
     * 使用回溯法，由于不确定digits的长度，也就导致了for循环的层数不能确定，所以不能用for循环
     */
    public void back(String digits,int index){
        //终止条件：buffer长度到达了指定长度
        if (index==digits.length()){
            list.add(buffer.toString());
            return;
        }
        char[] tmpchar=strings[digits.charAt(index)-'2'].toCharArray();
        for (char c : tmpchar) {
            //buffer就是到前面的index表示的字母的组合，这里把当前index遍历到的字母放入buffer
            buffer.append(c);
            back(digits, index+1);
            //把当前index遍历到的字母去除,因为如果不去除的话就会一直带下去，字符串越来越长
            buffer.deleteCharAt(buffer.length()-1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations l=new LetterCombinations();
        l.letterCombinations("23").forEach(System.out::println);
    }
}
