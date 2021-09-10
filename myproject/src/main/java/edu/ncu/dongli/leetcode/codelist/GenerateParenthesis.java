package edu.ncu.dongli.leetcode.codelist;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * 有效括号组合需满足：左括号必须以正确的顺序闭合。
 *   输入：n = 3
 *   输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) return res;
        // 执行深度优先遍历，搜索可能的结果
        dfs("", n, n, res);
        return res;
    }

    /**
     * @param curStr 当前递归得到的结果
     * @param left   左括号剩余几个可以使用
     * @param right  右括号剩余几个可以使用
     * @param res    结果集
     */
    private void dfs(String curStr, int left, int right, List<String> res) {
        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
        // 在递归终止的时候，直接把它添加到结果集即可
        if (left==0 && right==0) {
            res.add(curStr);
            return;
        }
        //剪枝（左括号剩余可以使用的个数严格大于右括号剩余可以使用的个数，才剪枝：因为left大于right就说明右括号多用了，不符合正确顺序）
        if (left>right) return;
        //left大于0就是说还有左括号可以用
        if (left>0) dfs(curStr + "(", left - 1, right, res);
        //right大于0就是说还有右括号可以用
        if (right>0) dfs(curStr + ")", left, right - 1, res);
    }
}
