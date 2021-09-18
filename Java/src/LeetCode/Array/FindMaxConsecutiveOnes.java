package LeetCode.Array;

import java.util.Arrays;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int answer = 0;

        int length = 0;
        for(int nIndex = 0; nIndex < nums.length; ++nIndex) {
            if(1 != nums[nIndex]) {
                answer = (length > answer) ? length : answer;
                length = 0;
                continue;
            }
            ++length;
        }

        return (length > answer) ? length : answer;
    }

    private boolean IsEvenOnly(int number){
        int count = 0;
        while(number > 0){
            number /= 10;
            ++count;
        }
        return count % 2 == 0;
    }

    public int findNumbers(int[] nums) {
        int answer = 0;
        for(final int num : nums){
            if(IsEvenOnly(num))
                ++answer;
        }
        return answer;
    }

    public int[] sortedSquares(int[] nums) {
        for(int nIndex = 0 ; nIndex < nums.length; ++nIndex)
        {
            nums[nIndex] *= nums[nIndex];
        }

        Arrays.sort(nums);

        return nums;
    }
}

public class FindMaxConsecutiveOnes {
    public static void main(String[] args){
        Solution sol = new Solution();
        /*System.out.println(sol.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
        System.out.println(sol.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));*/
//        System.out.println(sol.findNumbers(new int[]{555, 901, 482, 1771}));
//        System.out.println(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10}));
    }
}
