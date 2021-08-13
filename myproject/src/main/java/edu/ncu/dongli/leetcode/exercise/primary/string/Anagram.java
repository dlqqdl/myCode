package edu.ncu.dongli.leetcode.exercise.primary.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 问题：有效的字母异位词
 * 描述：
 *      给定两个字符串s和t,编写一个函数来判断t是否是s的字母异位词。
 * 注意：
 *      若s和t中每个字符出现的次数都相同，则称S和t互为字母异位词。
 *      把所有的当做小写字母
 * 示例1:
 *      输入: s = "anagram", t = "nagaram"
 *      输出: true
 * 示例 2:
 *      输入: s = "rat", t = "car"
 *      输出: false
 *
 */
public class Anagram {
    /**
     * 进行词频统计，自然想到使用map：
     * 两个map对两个字符串进行统计，字母作为key，出现次数作为value
     * 再对这两个map进行比较即可
     * 效率很低
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_CountByMap(String s, String t) {
        //长度不同，肯定不是字母异位词
        if (s.length()!=t.length())
            return false;
        Map<Character,Integer> sMap=new HashMap<>();
        Map<Character,Integer> tMap=new HashMap<>();
        //字母作为key，不区分大小写，所以要转
        s=s.toLowerCase();
        t=t.toLowerCase();
        //统计
        for (int i=0;i<s.length();i++){
            sMap.put(s.charAt(i),sMap.getOrDefault(s.charAt(i),0)+1);
            tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
        }
        //对两个map的key指向的value一一比较
        if (sMap.size()!=tMap.size())
            return false;
        for (char sKey : sMap.keySet()) {
            if (!sMap.get(sKey).equals(tMap.get(sKey)))
                return false;
        }
        return true;
    }

    /**
     * 使用数组来统计词频，规模较小时，数组更快，效率更高
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_CountByArray(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letterCount = new int[26];
        //统计字符串s中的每个字符的数量
        for (int i = 0; i < s.length(); i++)
            letterCount[s.charAt(i) - 'a']++;
        //减去字符串t中的每个字符的数量
        for (int i = 0; i < t.length(); i++)
            letterCount[t.charAt(i) - 'a']--;
        //如果数组letterCount的每个值都是0，返回true，否则返回false
        for (int count : letterCount)
            if (count != 0)
                return false;
        return true;
    }

    /**
     * 可以使用排序解决
     * 先对这两个string分别按照字母顺序排序，然后一一对应比较即可,
     * 效率较高
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram_Sort(String s, String t) {
        //长度不同，肯定不是字母异位词
        if (s.length()!=t.length())
            return false;
        //转数组
        char[] sChr=s.toCharArray();
        char[] tChr=t.toCharArray();
        //排序
        Arrays.sort(sChr);
        Arrays.sort(tChr);
        //一一比较
        for (int i=0;i<sChr.length;i++)
            if (sChr[i]!=tChr[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram=new Anagram();
        String s1="hello";
        String t1="holle";
        String s2="hello";
        String t2="htlle";
//        System.out.println(anagram.isAnagram_CountByMap(s1,t1));
//        System.out.println(anagram.isAnagram_CountByMap(s2,t2));

        System.out.println(anagram.isAnagram_Sort(s1,t1));
        System.out.println(anagram.isAnagram_Sort(s2,t2));
    }
}
