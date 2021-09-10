package edu.ncu.dongli.leetcode.codelist;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合。
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Parenthesis {
    public boolean isValid(String s) {
        if (s.length()<2)
            return false;
        Stack<Character> stack=new Stack<>();
        for (char c:s.toCharArray()) {
            if (c=='(')
                stack.push(')');
            else if (c=='[')
                stack.push(']');
            else if (c=='{')
                stack.push('}');
            else if (stack.isEmpty()||c!=stack.pop())
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Parenthesis parenthesis =new Parenthesis();
        System.out.println(parenthesis.isValid(""));
        System.out.println(parenthesis.isValid("[]{}()"));
        System.out.println(parenthesis.isValid("[}"));
        System.out.println(parenthesis.isValid("{}"));
        System.out.println(parenthesis.isValid("(]"));
    }
}
