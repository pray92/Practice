package LeetCode;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {        
        List<List<Integer>> answer = new ArrayList<>();
        
        answer.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        for(int i = 0; i < getFactorial(nums.length) - 1; ++i){
            List<Integer> lastElement = answer.get(answer.size() - 1);
            List<Integer> candidate = getNextPermutation(lastElement);
            answer.add(candidate);
        }

        return answer;
    }

    private List<Integer> getNextPermutation(List<Integer> nums){
        List<Integer> ret = new ArrayList<>();
        ret.addAll(nums);

        int i = nums.size() - 2;
        while(0 <= i && nums.get(i + 1) <= nums.get(i)){
            --i;
        }
        
        if(0 <= i){
            int j = nums.size() - 1;
            while(nums.get(i) >= nums.get(j)){
                --j;
            }
            Collections.swap(ret, i, j);
        }
        reverse(ret, i + 1);

        return ret;
    }

    private void reverse(List<Integer> list, int start){
        int i = start;
        int j = list.size() - 1;
        while(i < j){
            Collections.swap(list, i, j);
            i++;
            j--;
        }
    }

    private int getFactorial(int num){
        if(num <= 1){
            return 1;
        }
        return num * getFactorial(num - 1);
    }

    public static void main(String[] args){
        new Permutation().permute(new int[]{1,2,3});
    }
}
