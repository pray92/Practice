package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 21:39 ~ 22:26
public class MedianOfTwoSortedArrays {

/*    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return 0d;

        double answer= 0;

        int left1 = 0, right1 = nums1.length - 1;
        int left2 = 0, right2 = nums2.length - 1;
        int candidate1 = Integer.MAX_VALUE, candidate2 = Integer.MAX_VALUE;
        while(left1 <= right1 || left2 <= right2){
            int mid1 = (left1 + right1) >> 1;
            if(left1 <= right1){
                candidate1 = nums1[mid1];
            }

            int mid2 = (left2 + right2) >> 1;
            if(left2 <= right2){
                candidate2 = nums2[mid2];
            }

            if(candidate1 == candidate2)
                break;

            if(candidate1 < candidate2){
                left1 = mid1 + 1;
                right2 = mid2 - 1;
            }
            else{
                right1 = mid1 - 1;
                left2 = mid2 + 1;
            }
        }
        if(nums1.length != nums2.length)
            answer = (candidate1 < candidate2) ? candidate1 : candidate2;
        else
            answer = (candidate1 + candidate2) / 2d;
        return answer;
    }*/

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int num : nums1)
            pq.add(num);
        for(int num : nums2)
            pq.add(num);

        double answer = 0d;

        int totalSize = pq.size();
        if(totalSize % 2 == 0) {
            int value1 = 0, value2 = 0;
            for(int i = 0 ; i < totalSize; ++i){
                int value = pq.poll();
                if(i == (totalSize >> 1) - 1){
                    value1 = value;
                }
                else if(i == (totalSize >> 1)){
                    value2 = value;
                    break;
                }
            }
            answer = (value1 + value2) / 2d;
        }
        else{
            for(int i = 0 ; i < totalSize; ++i){
                int value = pq.poll();
                if(i == (totalSize >> 1)){
                    answer = value;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args){
        double ans = new MedianOfTwoSortedArrays().findMedianSortedArrays(
                new int[]{1, 3},
                new int[]{2});
        System.out.println(ans);
    }
}
