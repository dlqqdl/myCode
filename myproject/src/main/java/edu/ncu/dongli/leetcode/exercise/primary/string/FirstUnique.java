package edu.ncu.dongli.leetcode.exercise.primary.string;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 问题：字符串中的第一个唯一字符
 * 描述：给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1；假定该字符串只包含小写字母
 * 示例：
 *      s = "leetcode"
 *      返回 0
 *      s = "loveleetcode"
 *      返回 2
 */
public class FirstUnique {
    /**
     * 通过map，将所有的char作为key放入其中，value同于存出现次数
     * 然后遍历map，次数为1的就是结果
     * 这里的map要使用LinkedHashMap：
     * 因为这个结构的map能够保证put的顺序，在遍历的时候才能保证取出第一个唯一值
     * 效率很低
     * @param s
     * @return
     */
    public int firstUniqueCharByMap(String s) {
        s=s.toLowerCase();//全部变成小写，因为不区分大小写，变了也没关系
        Map<String,Integer> map=new LinkedHashMap<>();//key是这个字符，value是出现次数
        for (int i=0;i<s.length();i++){
            map.put(s.charAt(i)+"",map.getOrDefault(s.charAt(i)+"",0)+1);
        }
        for (int i = 0; i < s.length(); i++)
            if (map.get(s.charAt(i)+"") == 1)
                return i;
        return -1;
    }

    /**
     * 利用数组
     * 两次遍历，使用数组来存字符串出现次数，这个数组中第一个1就是结果
     * 效率比较高
     * @param s
     * @return
     */
    public int firstUniqueCharByArray(String s) {
        char[] chr=s.toCharArray();//转数组
        int[] cnt=new int[26];
        for (int i=0;i<chr.length;i++){
            cnt[(int)chr[i]-97]++;
        }
        for (int i=0;i<chr.length;i++)
            if (cnt[(int)chr[i]-97]==1)
                return i;
        return -1;
    }

    /**
     * java的String api
     * 遍历String,当从后往前匹配到的字符位置和从前往后匹配到的字符位置相同。就说明唯一了
     * 效率一般
     * @param s
     * @return
     */
    public int firstUniqueCharByJavaApi(String s) {
        s=s.toLowerCase();
        for (int i=0;i<s.length();i++)
            if (s.indexOf(s.charAt(i))==s.lastIndexOf(s.charAt(i)))
                return i;
        return -1;
    }

    public static void main(String[] args) {
        FirstUnique firstUnique=new FirstUnique();
        //System.out.println(firstUnique.firstUniqueCharByMap("dddccdbba"));
        //System.out.println(firstUnique.firstUniqueCharByMap("leetcode"));

        System.out.println(firstUnique.firstUniqueCharByArray("dddccdbba"));
        System.out.println(firstUnique.firstUniqueCharByArray("leetcode"));

//        System.out.println(firstUnique.firstUniqueCharByJavaApi("dddccdbba"));
//        System.out.println(firstUnique.firstUniqueCharByJavaApi("leetcode"));
    }
}
