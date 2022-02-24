package LeetCode;

public class JumpGamesII {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        for(int i = 0; i < nums.length; ++i){
            dp[i] = (i <= nums[0]) ? 1 : 10001;
        }
        dp[0] = 0;

        for(int i = 1; i < nums.length; ++i){
            int nCnt = nums[i];
            for(int j = i;j <= i + nCnt && j < nums.length; ++j){
                dp[j] = Math.min(dp[i] + 1, dp[j]);
            }
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args){
        new JumpGamesII().jump(new int[]{2,3,1,1,4});
    }
}
