package LeetCode;

import java.util.Arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] lArr = Arrays.copyOfRange(nums1, 0, m);
        int i = 0, j = 0, k = 0;
        while(i < m && j < n){
            if(lArr[i] <= nums2[j]) nums1[k++] = lArr[i++];
            else nums1[k++] = nums2[j++];
        }

        while(i < m) nums1[k++] = lArr[i++];
        while(j < n) nums1[k++] = nums2[j++];
    }
}
