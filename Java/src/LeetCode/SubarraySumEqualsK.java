package LeetCode;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int answer = 0;

        for(int offset = 0; offset < nums.length; ++offset){
            int value = 0;
            for(int start = offset; start < nums.length; ++start){
                value += nums[start];
                if(value > k){
                    break;
                }

                if(value == k){
                    ++answer;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        var ret = new SubarraySumEqualsK().subarraySum(new int[]{1, -1, 0}, 0);

    }
}
