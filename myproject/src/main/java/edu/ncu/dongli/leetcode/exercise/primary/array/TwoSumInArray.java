package edu.ncu.dongli.leetcode.exercise.primary.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 描述：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 * 示例：
 *      示例 1：
 *      输入：nums = [2,7,11,15], target = 9
 *      输出：[0,1]
 *      解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *      示例 2：
 *      输入：nums = [3,2,4], target = 6
 *      输出：[1,2]
 *      示例 3：
 *      输入：nums = [3,3], target = 6
 *      输出：[0,1]
 */
public class TwoSumInArray {

    /**
     * hashmap解决
     * 遍历数组，用当前值去减target，如果差值存在于map中，直接获取即可
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByMap(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    /**
     * 双指针解决
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSumByTwoPrinter(int[] nums, int target) {
        int j = 1;
        int i = 0;
        int maxArea = nums.length - 1;
        while (nums[i] + nums[j] != target){
            if(j == maxArea){
                i++;
                j = i;
            }
            j++;
        }
        return new int[]{i,j};
    }

    public static void main(String[] args) {
        TwoSumInArray twoSumInArray=new TwoSumInArray();
        int[] res=twoSumInArray.twoSumByTwoPrinter(new int[]{1,2,3,4},7);
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
        res=twoSumInArray.twoSumByMap(new int[]{1,2,3,9},5);
        for (int re : res) {
            System.out.print(re+" ");
        }
        System.out.println();
    }
}
