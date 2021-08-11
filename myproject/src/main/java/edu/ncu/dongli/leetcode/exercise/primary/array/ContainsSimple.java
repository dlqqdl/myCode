package edu.ncu.dongli.leetcode.exercise.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * 描述：
 *      给定一个整数数组，判断是否存在重复元素。
 *      如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsSimple {
    /**
     * 利用Array.sort()进行排序，然后查相邻元素就可以了，这样效率最高
     * @param nums
     * @return
     */
    public boolean containsDuplicateBySort(int[] nums) {
        Arrays.sort(nums);
        for (int ind = 1; ind < nums.length; ind++) {
            if (nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }
    /**
     * 使用set特性
     * @param nums
     * @return
     */
    public boolean containsDuplicateBySet(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++)
            if (!set.add(nums[i]))
                return true;
        return false;
    }

    public static void main(String[] args) {
        ContainsSimple cs=new ContainsSimple();
        System.out.println(cs.containsDuplicateBySort(new int[]{1, 2, 3, 1}));
        System.out.println(cs.containsDuplicateBySort(new int[]{1, 2, 3, 4}));
        System.out.println(cs.containsDuplicateBySort(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
