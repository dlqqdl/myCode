package edu.ncu.dongli.leetcode.exercise.primary.array;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

/**
 * 问题：两个数组的交集 II
 * 描述：
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 示例：
 *      输入：nums1 = [1,2,2,1], nums2 = [2,2]
 *      输出：[2,2]
 */
public class IntersectInArray {
    /**
     * 先进行排序，然后利用双指针解决:
     * 先对两个数组进行排序，然后使用两个指针，分别指向两个数组开始的位置。
     * 如果两个指针指向的值相同，说明这个值是他们的交集，就把这个值加入到集合list中，然后两个指针在分别往后移一步。
     * 如果两个指针指向的值不同，那么指向的值相对小的往后移一步，相对大的先不动，然后再比较
     * 一直重复上面的操作，直到其中一个指针不能再移动为止，最后再把集合list转化为数组即可。
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectBySort(int[] nums1, int[] nums2) {
        //排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //双指针
        int ops1=0;
        int ops2=0;
        //因为不知道一共会有多少个数，所以用到list
        List<Integer> list=new ArrayList<>();
        for (;ops1<nums1.length && ops2< nums2.length;){
            if (nums1[ops1]==nums2[ops2]){
                list.add(nums1[ops1]);
                ops1++;
                ops2++;
            }
            else if (nums1[ops1]>nums2[ops2])
                ops2++;
            else if(nums1[ops1]<nums2[ops2])
                ops1++;
        }
        //转换为数组
        int index = 0;
        int[] res = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            res[index++] = list.get(k);
        }
        return res;
    }


    /**
     * 利用map解决：
     * 遍历nums1中的所有元素，把它存放到map中，其中key就是nums1中的元素，value就是这个元素在数组nums1中出现的次数。
     * 遍历nums2中的所有元素，查看map中是否包含nums2的元素，如果包含，就把当前值加入到集合list中，然后对应的value要减1。
     * 最后再把集合list转化为数组即可
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersectByMap(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }

        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        IntersectInArray intersectInArray=new IntersectInArray();
        int[] res1=intersectInArray.intersectBySort(new int[]{1,2,3,5,1,2},new int[]{1,1,2,5});
        for (int re : res1) {
            System.out.print(re+" ");
        }

        int[] res2=intersectInArray.intersectByMap(new int[]{1,2,3,5,1,2},new int[]{1,1,2,5});
        for (int re : res2) {
            System.out.print(re+" ");
        }
    }
}
