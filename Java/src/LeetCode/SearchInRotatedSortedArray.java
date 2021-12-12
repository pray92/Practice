package LeetCode;

import java.util.Arrays;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        if(start >= end)
            return (nums[start] == target) ? start : -1;

        int ret = -1;
        int mid = (start + end) >>> 1;
        if(nums[mid] == target){
            ret = mid;
        } else{
            ret = binarySearch(nums, start, mid - 1, target);
            if(ret < 0)
                ret = binarySearch(nums, mid + 1, end, target);
        }

        return ret;
    }

    public static void main(String[] args){
        var ret = new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ret);
    }
}
