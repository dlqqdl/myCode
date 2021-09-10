package edu.ncu.dongli.leetcode.codelist;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int len=nums.length;
        if (nums==null||len<3)
            return 0;
        Arrays.sort(nums);
        int closest=Integer.MAX_VALUE;//记录这个接近的数
        int closestSub=Integer.MAX_VALUE;//记录这个接近的数
        for (int i=0;i<len-2;i++){
            int left=i+1;
            int right=len-1;//下标为i的数组的后面的元素
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                int sub=sum-target;
                if (sub==0)
                    return target;//相差0，直接返回就好了，没有更小的了
                else if (sub<0){
                    left++;//说明小的部分多了
                }
                else
                    right--;
                sub=Math.abs(sub);
                closestSub=Math.min(closestSub,sub);
                if (closestSub==sub)
                    closest=sum;
            }
        }
        return closest;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSumClosest=new ThreeSumClosest();
        System.out.println(threeSumClosest.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
