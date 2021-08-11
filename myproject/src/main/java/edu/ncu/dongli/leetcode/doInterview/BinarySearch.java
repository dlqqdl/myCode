package edu.ncu.dongli.leetcode.doInterview;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int low=0;
        int high=nums.length;
        while (low<high){
            int mid=(low+high)/2;
            if (nums[mid]==target)
                return mid;
            else if (nums[mid]>target){
                high=mid;
            }
            else
                low=mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int res=search(new int[]{-1,0,3,5,9,12},12);
        int res2=search(new int[]{1, 2, 3, 1},1);
        System.out.println(res);
        System.out.println(res2);
    }
}
