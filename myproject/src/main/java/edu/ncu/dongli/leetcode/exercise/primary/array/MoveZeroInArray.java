package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 问题：移动零
 * 描述：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 必须在原数组上操作，不能拷贝额外的数组。尽量减少操作次数。
 * 示例：
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 */
public class MoveZeroInArray {
    /**
     * 通过一个指针not0始终去找nums中不为0的数，
     * 另一个指针index始终指向下一个不为0的数应该放的位置
     * 当nums遍历完后，index之后的全部置为0即可
     * @param nums
     */
    public void moveZeroes_1(int[] nums) {
        int index=0;
        for (int not0=0;not0<nums.length;not0++){
            if (nums[not0]!=0)
                nums[index++]=nums[not0];
        }
        for (;index<nums.length;index++){
            nums[index]=0;
        }
    }

    /**
     * 另一种双指针的思路解决，指针j是一直往后移动的，如果指向的值不等于0才对他进行操作。
     * 而i统计的是前面0的个数，
     * 我们把j-i看做另一个指针，它是指向前面第一个0的位置，然后我们让j指向的值和j-i指向的值交换
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {
        int i = 0;//统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            //如果当前数字是0,就只统计0的个数
            if (nums[j] == 0)
                i++;
            else if (i != 0) {
                //否则，把当前数字放到最前面那个0的位置，然后再把当前位置设为0
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        MoveZeroInArray moveZeroInArray=new MoveZeroInArray();
        int[] nums=new int[]{0,1,2,0,3,0,5};
        moveZeroInArray.moveZeroes_1(nums);
        for (int num : nums) {
            System.out.print(num+" ");
        }
    }
}
