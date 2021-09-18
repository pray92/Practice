package Programmers;

class Solution {
    public int solution(int[] numbers) {
        boolean[] checks = new boolean[10];
        int answer = 0;

        for(var number : numbers)
            checks[number] = true;

        for(int nIndex = 0 ; nIndex < checks.length; ++nIndex)
        {
            var check = checks[nIndex];
            if(!check)
                answer += nIndex;
        }

        return answer;
    }
}

public class PlusNumbers {

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{1,2,3,4,6,7,8,0}));
        System.out.println(sol.solution(new int[]{5,8,4,0,6,7,9}));
    }
}
