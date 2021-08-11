package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 问题：删除排序数组中的重复项
 * 描述：
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 *
 * 示例 2：
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicates {
    /**
     * 利用双指针解决
     *（1）当左指针的值等于右指针的值时：左指针不动，右指针右移
     *（2）当左指针的值不等于右指针的值时，左指针右移，右指针赋值给左指针
     * @param  A int[]
     * @return A‘s len int
     */
    public int removeDuplicatesByPointer(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++)
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩指向的值不一样就把右指针指向的值往前挪到左指针的位置
            if (A[left] != A[right])
                A[++left] = A[right];
        return ++left;//因为从0开始，所以要再加1才是新的长度
    }

    /**
     * 通过一个常量counter记录重复的次数，用于自增
     * 遍历数组，当前的值与它相邻的值比较：
     * （1）当前的值与它相邻的值相等，则counter++
     * （2）当前的值与它相邻的值不相等，则当前值向前移counter个位置
     * @param  A int[]
     * @return A‘s len int
     */
    public int removeDuplicatesByCounter(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int counter=0;//记录重复次数
        for (int pos=1;pos<A.length;pos++){
            if (A[pos]==A[pos-1])
                counter++;//相邻的值相同，重复了，counter++
            else
                A[pos-counter]=A[pos];//没有重复，则向前移动counter个位置
        }
        return A.length-counter;//因为重复了counter个数，所以减去之后就是实际的长度
    }

    public static void main(String[] args) {
        RemoveDuplicates rd=new RemoveDuplicates();
        System.out.println(rd.removeDuplicatesByCounter(new int[]{0, 0, 1, 2, 2, 2, 3, 3, 5, 9}));
        System.out.println(rd.removeDuplicatesByPointer(new int[]{0, 0, 1, 2, 2, 2, 3, 3, 5, 9}));

    }
}
