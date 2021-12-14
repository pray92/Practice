package LeetCode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};

        if(nums.length == 0){
            return ret;
        } else if(nums.length == 1){
            if(nums[0] == target){
                return new int[]{0, 0};
            } else{
                return ret;
            }
        }

        int firstIndex = Arrays.binarySearch(nums, target);
        if(firstIndex < 0)
            return ret;

        // 최소 인덱스 찾기
        int minIndex = firstIndex;
        int left = 0, right = firstIndex - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;

            if(nums[mid] < target) {
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            }
            else{
                minIndex = mid;
                right = mid - 1;
            }
        }
        ret[0] = minIndex;

        // 최대 인덱스 찾기
        int maxIndex = firstIndex;
        left = firstIndex + 1;
        right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) >>> 1;

            if(nums[mid] < target) {
                left = mid + 1;
            } else if(target < nums[mid]) {
                right = mid - 1;
            }
            else{
                maxIndex = mid;
                left = mid + 1;
            }
        }
        ret[1] = maxIndex;

        return ret;
    }

    public static void main(String[] args){
        var ret = new FindFirstAndLastPositionOfElementInSortArray().searchRange(new int[]{1, 3}, 1);
    }
}
