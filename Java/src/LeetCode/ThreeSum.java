package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length < 3)
            return answer;

        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; ++i){
            int nLeft = i + 1;
            int nRight = nums.length - 1;
            while(nLeft < nRight){
                List<Integer> values = new ArrayList<>();
                {
                    values.add(nums[i]);
                    values.add(nums[nLeft]);
                    values.add(nums[nRight]);
                }
                int nCandidate = values.get(0) + values.get(1) +values.get(2);
                if(nCandidate == 0){
                    if(!answer.contains(values))
                        answer.add(values);
                    ++nLeft; --nRight;
                }
                else if(nCandidate < 0){
                    ++nLeft;
                }
                else{
                    --nRight;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        List<List<Integer>> ans = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        ans = new ThreeSum().threeSum(new int[]{-2, 0, 1, 1, 2});

    }
}
