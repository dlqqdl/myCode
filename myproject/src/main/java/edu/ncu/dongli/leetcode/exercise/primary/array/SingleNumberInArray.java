package edu.ncu.dongli.leetcode.exercise.primary.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 问题：只出现一次的数字
 * 描述：
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 */
public class SingleNumberInArray {
    /**
     * set集合特性，去重性
     * 最后set中只留下没有重复的那个数
     * @param nums
     * @return
     */
    public int singleNumberBySet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                set.remove(num);//如果添加失败，说明这个值在集合Set中存在，我们要把他给移除掉
            }
        }
        //最终集合Set中只有一个元素，我们直接返回
        return (int) set.toArray()[0];
    }

    /**
     * 利用异或运算的特性：0^A=A;A^A=0
     * 又由于异或运算支持交换律：A^B^C^A=A^A^B^C=0^B^C=B^C
     * 所以通过0去遍历数组就求出来不同的那个数
     * 这个方法的时间复杂度最低：O(n)，且效率最高
     * @param nums
     * @return
     */
    public int singleNumberByXOR(int[] nums) {
        int res=0;
        for (int i=0;i<nums.length;i++){
            res=res^nums[i];
        }
        return res;
    }

    /**
     * 利用排序解决，虽然效率不高，但是也能行
     * @param nums
     * @return
     */
    private int singleNumberBySort(int[] nums){
        Arrays.sort(nums);
        int res=nums[0];
        int i=0;
        for (;i<nums.length-1;i+=2){
            if (nums[i]!=nums[i+1])
                return nums[i];
        }
        //边界处理，如果前面没找到，就说明是最后一个不同
        if(i>=nums.length-1)
            res=nums[nums.length-1];
        return res;
    }

    public static void main(String[] args) {
        SingleNumberInArray singleNumberInArray=new SingleNumberInArray();
        //System.out.println(singleNumberInArray.singleNumberBySet(new int[]{10, 2, 2, 3, 3, 5, 5, 9, 9}));
        //System.out.println(singleNumberInArray.singleNumberByXOR(new int[]{10, 2, 2, 3, 3, 5, 5, 9, 9}));
        System.out.println(singleNumberInArray.singleNumberBySort(new int[]{10, 2, 2, 3, 3, 5, 5, 9, 9}));
    }
}
