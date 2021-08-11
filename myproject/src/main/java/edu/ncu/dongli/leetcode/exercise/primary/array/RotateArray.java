package edu.ncu.dongli.leetcode.exercise.primary.array;

/**
 * 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 示例：
 *      输入: nums = [1,2,3,4,5,6,7], k = 3
 *      输出: [5,6,7,1,2,3,4]
 *      解释:
 *          向右旋转 1 步: [7,1,2,3,4,5,6]
 *          向右旋转 2 步: [6,7,1,2,3,4,5]
 *          向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 *      输入：nums = [-1,-100,3,99], k = 2
 *      输出：[3,99,-1,-100]
 *      解释:
 *          向右旋转 1 步: [99,-1,-100,3]
 *          向右旋转 2 步: [3,99,-1,-100]
 */
public class RotateArray {
    /**
     * 最普通的解决方法：创建新的数组空间进行处理
     * @param nums
     * @return
     */
    public void rotateArray_Normal(int[] nums,int k){
        if (nums.length<1 || k<0)
            return ;
        int length=nums.length;
        //如果k>=length，就说明可以取余，因为多移了一轮
        int step=k;
        if (k>=length)
            step=k%length;
        int[] res=new int[length];
        //nums的后step个复制到res的前step个
        for (int i=length-step,j=0;i<length;i++,j++)
            res[j]=nums[i];
        //nums的前length-step个复制到res的后length-step个
        for(int i=0,j=step;i<length-step;i++,j++)
            res[j]=nums[i];
        for (int i=0;i<length;i++)
            nums[i]=res[i];
    }

    /**
     * 环形旋转:把数组看作是环形的，每一个都往后移动k位
     * 可以使用一个数组visited表示这个元素有没有被访问过，如果被访问过就从他的下一个开始，防止原地打转。
     * @param nums
     * @param k
     */
    public static void rotateArray_Around(int[] nums, int k) {
        int hold = nums[0];
        int index = 0;
        int length = nums.length;
        boolean[] visited = new boolean[length];
        for (int i = 0; i < length; i++) {
            index = (index + k) % length;
            if (visited[index]) {
                //如果访问过，再次访问的话，会出现原地打转的现象，
                //不能再访问当前元素了，我们直接从他的下一个元素开始
                index = (index + 1) % length;
                hold = nums[index];
                i--;
            } else {
                //把当前值保存在下一个位置，保存之前要把下一个位置的
                //值给记录下来
                visited[index] = true;
                int temp = nums[index];
                nums[index] = hold;
                hold = temp;
            }
        }
    }

    public static void main(String[] args) {
        RotateArray ra=new RotateArray();
        int n[]=new int[]{99,-1,-100,3};
        ra.rotateArray_Normal(n,5);
        System.out.println();
        for (int num : n) {
            System.out.print(num+" ");
        }
    }
}
