package LeetCode;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; ++i){
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }


    // Time exceed
    /*public int maxSubArray(int[] nums) {
        return getValue(nums, 0, nums.length - 1);
    }

    private int getValue(int[] nums, int left, int right){
        if(left >= right)
            return nums[left];

        return Math.max(getSum(nums, left, right), Math.max(getValue(nums, left + 1, right), getValue(nums, left, right - 1)));
    }

    private int getSum(int[] nums, int left, int right){
        int sum = 0;
        for(int i = left; i <= right; ++i){
            sum += nums[i];
        }
        return sum;
    }*/
}
