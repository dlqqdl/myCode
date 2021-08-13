package edu.ncu.dongli.leetcode.exercise.primary.string;

/**
 * 问题：验证回文串
 * 描述：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。字符串 s 由 ASCII 字符组成
 * 示例 1:
 *      输入: "A man, a plan, a canal: Panama"
 *      输出: true
 *      解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 *      输入: "race a car"
 *      输出: false
 *      解释："raceacar" 不是回文串
 */
public class Palindrome {
    /**
     * 双指针：左边的指针向后，右边的指针向前，遇到特殊字符就跳过
     * @param s
     * @return
     */
    public boolean isPalindrome_TwoPrinter(String s) {
        if (s.length() == 0)
            return true;
        s=s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
                left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
                right--;
            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
            if (s.charAt(left)!= s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    /**
     * 使用正则表达式先过滤特殊字符然后反转比较
     * @param s
     * @return
     */
    public boolean isPalindrome_Regex(String s) {
        //过滤特殊字符
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        //然后反转
        String rev = new StringBuffer(s).reverse().toString();
        //反转后与原串比较
        return s.equals(rev);
    }

    public static void main(String[] args) {
        Palindrome palindrome=new Palindrome();
        System.out.println(palindrome.isPalindrome_TwoPrinter("A man, a plan, a canal: Panama"));
        System.out.println(palindrome.isPalindrome_TwoPrinter(",,"));
    }
}
