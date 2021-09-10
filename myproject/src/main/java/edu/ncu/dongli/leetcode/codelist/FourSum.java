package edu.ncu.dongli.leetcode.codelist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]] ：
 *      0 <= a,b,c,d<n
 *      a,b,c和d互不相同
 *      nums[a]+nums[b]+nums[c]+nums[d]==target
 * 链接：https://leetcode-cn.com/problems/4sum
 */
public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<List<Integer>>(); // 定义一个返回值
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        Arrays.sort(nums);
        int length = nums.length;
        // 定义4个指针i,j,left,right  i从0开始遍历,j从i+1开始遍历,留下left和right作为双指针
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 当i的值与前面的值相等时忽略
                continue;
            }
            // 获取当前最小值,如果最小值比目标值大,说明后面越来越大的值根本没戏
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break; // 这里使用的break,直接退出此次循环,因为后面的数只会更大
            }
            // 获取当前最大值,如果最大值比目标值小,说明后面越来越小的值根本没戏,忽略
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue; // 这里使用continue,继续下一次循环,因为下一次循环有更大的数
            }
            // 第二层循环j,初始值指向i+1
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) { // 当j的值与前面的值相等时忽略
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int left = j + 1, right = length - 1;
                // 双指针遍历,如果等于目标值,left++并去重,right--并去重,当当前和大于目标值时right--,当当前和小于目标值时left++
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++; // left先+1之后,和它前面的left-1进行比较,若后+1,则和它后面的left+1进行比较
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        right--;
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return quadruplets;
    }

    public static void main(String[] args) {
        FourSum fourSum=new FourSum();
        fourSum.fourSum(new int[]{1,0,-1,0,-2,2},0).forEach(System.out::println);
        fourSum.fourSum(new int[]{2,2,2,2,2},8).forEach(System.out::println);
        fourSum.fourSum(new int[]{-3,-1,0,2,4,5},2).forEach(System.out::println);
    }
}
