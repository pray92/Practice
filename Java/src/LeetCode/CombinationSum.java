package LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 13:00
public class CombinationSum {

    private class CombinationInfo {
        public int offsetIndex;
        public List<Integer> subset = new ArrayList<>();
        public int total;

    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        Queue<CombinationInfo> queue = new LinkedList<>();
        for(int index = 0; index < candidates.length; ++index){
            CombinationInfo info = new CombinationInfo();
            info.offsetIndex = index;
            info.subset.add(candidates[index]);
            info.total = candidates[index];
            queue.add(info);
        }

        while(!queue.isEmpty()){
            CombinationInfo info = queue.poll();

            if(info.total == target){
                answer.add(info.subset);
            }

            for(int index = info.offsetIndex; index < candidates.length; ++index){
                if(info.total + candidates[index] > target)
                    continue;

                CombinationInfo info2 = new CombinationInfo();
                info2.offsetIndex = index;
                info2.subset = new ArrayList<>(info.subset);
                info2.subset.add(candidates[index]);
                info2.total = info.total + candidates[index];
                queue.add(info2);
            }
        }

        return answer;
    }
}
