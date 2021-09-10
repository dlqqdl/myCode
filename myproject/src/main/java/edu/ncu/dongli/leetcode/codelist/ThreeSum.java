package edu.ncu.dongli.leetcode.codelist;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，
 * 使得a + b + c = 0  请你找出所有和为 0 且不重复的三元组。
 * 链接：https://leetcode-cn.com/problems/3sum
 */
public class ThreeSum {

    /**
     * 首先对数组进行排序，排序后固定一个数 nums[i]nums[i]，再使用左右指针指向 nums[i]nums[i]后面的两端，数字分别为 nums[L]nums[L] 和 nums[R]nums[R]，计算三个数的和 sumsum 判断是否满足为 00，满足则添加进结果集
     * 如果 nums[i]nums[i]大于 00，则三数之和必然无法等于 00，结束循环
     * 如果 nums[i]nums[i] == nums[i-1]nums[i−1]，则说明该数字重复，会导致结果重复，所以应该跳过
     * 当 sumsum == 00 时，nums[L]nums[L] == nums[L+1]nums[L+1] 则会导致结果重复，应该跳过，L++L++
     * 当 sumsum == 00 时，nums[R]nums[R] == nums[R-1]nums[R−1] 则会导致结果重复，应该跳过，R--R−−
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_1(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3)
            return new ArrayList<>();
        Arrays.sort(nums);
        List<List<Integer>> list=new ArrayList();
        for(int i=0;i<nums.length;i++){
            Map<Integer,Integer> map=new HashMap<>();//key是这个数，value是出现的位置
            int target=0-nums[i];
            for(int j=i+1;j<nums.length;j++){
                if(map.containsKey(target-nums[j])){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(target-nums[j]);
                    if (!list.contains(tmp))
                        list.add(tmp);
                }
                map.put(nums[j],j);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum threeSum=new ThreeSum();
        //threeSum.threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(System.out::println);
        threeSum.threeSum_1(new int[]{-1,0,1,2,-1,-4}).forEach(System.out::println);
        System.out.println("---------------------");
        threeSum.threeSum_1(new int[]{0,0,0}).forEach(System.out::println);
        System.out.println("---------------------");
        threeSum.threeSum_1(new int[]{0,0,0,0}).forEach(System.out::println);
    }
}
