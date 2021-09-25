package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> checkMap = new HashMap<>();
        for(int nIndex = 0 ; nIndex < nums.length; ++nIndex){
            final int num = nums[nIndex];
            if(checkMap.containsKey(num))
            {
                return new int[]{ checkMap.get(num), nIndex };
            }

            checkMap.put(target - num, nIndex);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args){
        TwoSum sol = new TwoSum();
        var ans = sol.twoSum(new int[]{3, 2, 4}, 6);
        System.out.println(ans[0] + "," + ans[1]);
        ans = sol.twoSum(new int[]{3, 3}, 6);
        System.out.println(ans[0] + "," + ans[1]);
    }
}
