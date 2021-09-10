package edu.ncu.dongli.leetcode.codelist;

/**
 * 最长回文字串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 */
public class LongestPalindrome {
    /**
     * 中心扩散法
     * 还可以用manacher方法和动态规划
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        if (s.length()<1)
            return "";
        int start=0;
        int end=0;
        for (int i=0; i<s.length(); i++) {
            int len1=expandAroundCenter(s, i, i);//一个元素为中心:aba
            int len2=expandAroundCenter(s, i, i+1);//两个元素为中心:abba
            int len=Math.max(len1, len2);
            if (len>(end-start+1)) {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }

    /**
     * 中心扩散
     * @param s
     * @param left
     * @param right
     * @return
     */
    public int expandAroundCenter(String s, int left, int right) {
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            // 计算以left和right为中心的回文串长度
            left--;
            right++;
        }
        return right-left-1;
    }
}
