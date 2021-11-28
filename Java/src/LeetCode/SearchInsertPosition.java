package LeetCode;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid = 0;
        while(left <= right){
            mid = (left + right) >> 1;
            if(nums[mid] < target){
                left = mid + 1;
            } else if(nums[mid] > target){
                right = mid - 1;
            } else{
                break;
            }
        }
        if(nums[mid] < target)
            ++mid;
        return mid;
    }

    public static void main(String[] args){
        new SearchInsertPosition().searchInsert(new int[]{1,3,5,6}, 5);
    }
}
