package LeetCode;


import java.util.HashMap;
import java.util.Map;

public class FIrstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for(int num : nums){
            if(num < 0){
                continue;
            }
            if(countMap.containsKey(num)){
                countMap.replace(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }

        for(int i = 1; i < Integer.MAX_VALUE; ++i){
            if(!countMap.containsKey(i))
                return i;
        }
        return Integer.MAX_VALUE;
    }
}
