package LeetCode;

import Utils.DoubleLinkedList;

import java.util.*;

public class CombinationSum2 {
    private class CombinationInfo {
        public int offsetIndex;
        public List<Integer> subset = new ArrayList<>();
        public int total;

    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        Queue<CombinationInfo> queue = new LinkedList<>();

        int prevCandi = 0;
        for(int index = 0; index < candidates.length; ++index){
            if(prevCandi == candidates[index])
                continue;

            CombinationInfo info = new CombinationInfo();
            info.offsetIndex = index;
            info.subset.add(candidates[index]);
            info.total = candidates[index];
            queue.add(info);
            prevCandi = candidates[index];
        }

        while(!queue.isEmpty()){
            CombinationInfo info = queue.poll();

            if(info.total == target){
                if(!answer.contains(info.subset)){
                    answer.add(info.subset);
                }
            }

            prevCandi = 0;
            for(int index = info.offsetIndex + 1; index < candidates.length; ++index){
                if(info.total + candidates[index] > target)
                    continue;

                if(prevCandi == candidates[index])
                    continue;

                CombinationInfo info2 = new CombinationInfo();
                info2.offsetIndex = index;
                info2.subset = new ArrayList<>(info.subset);
                info2.subset.add(candidates[index]);
                info2.total = info.total + candidates[index];
                queue.add(info2);
                prevCandi = candidates[index];
            }
        }

        return answer;
    }

    public static void main(String[] args){
        var ret = new CombinationSum2().combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
    }
}
