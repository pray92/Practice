package LeetCode;

import kotlin.random.AbstractPlatformRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

/*    void dfs(int[] nums, int target, List<List<Integer>> answer, int curIndex, int cnt, List<Integer> candidate){
        if(cnt >= 4){
            int value = candidate.stream().reduce(0, Integer::sum);
            if(value == target){
                List<Integer> answer2 = new ArrayList<>(candidate);
                if(!answer.contains(answer2)){
                    answer.add(answer2);
                }
            }

            return;
        }

        for(int i = curIndex + 1; i < nums.length; ++i){
            candidate.set(cnt, nums[i]);
            dfs(nums, target, answer, i, cnt + 1, candidate);
            candidate.set(cnt, 0);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        if(nums.length < 4)
            return answer;

        Arrays.sort(nums);

        List<Integer> candidate = new ArrayList<>();
        candidate.add(0);
        candidate.add(0);
        candidate.add(0);
        candidate.add(0);

        dfs(nums, target, answer, -1, 0, candidate);

        return answer;
    }*/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target,0, 4);
    }

    public List<List<Integer>> kSum(int[] nums, int target, int start, int end){
        List<List<Integer>> ret = new ArrayList<>();
        if(start == nums.length
            || nums[start] * end > target
            || target > nums[nums.length - 1] * end){
            return ret;
        }
        if(end == 2)
            return twoSum(nums, target, start);

        for(int i = start; i < nums.length; ++i){
            if(i == start || nums[i - 1] != nums[i]){
                for(List<Integer> subset : kSum(nums, target - nums[i], i + 1, end - 1)){
                    ret.add(new ArrayList<>(Arrays.asList(nums[i])));
                    ret.get(ret.size() - 1).addAll(subset);
                }
            }
        }

        return ret;
    }

    public List<List<Integer>> twoSum(int[] nums, int target, int start){
        List<List<Integer>> ret = new ArrayList<>();
        int left = start, right = nums.length - 1;
        while(left < right){
            int curSum = nums[left] + nums[right];
            if(curSum < target || (start < left && nums[left] == nums[left - 1])){
                ++left;
            }
            else if(curSum > target || (right < nums.length - 1 && nums[right] == nums[right + 1])){
                --right;
            }
            else {
                ret.add(Arrays.asList(nums[left++], nums[right--]));
            }
        }
        return ret;
    }

    public static void main(String[] args){
        var answer = new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for(var ans : answer){
            System.out.println(ans.toString() + ",");
        }
    }
}
