package Programmers;

import java.util.Arrays;

public class MakingMinValue {

    public int solution(int []A, int []B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; ++i){
            int ri = A.length - i - 1;
            answer += A[i] * B[ri];
        }

        return answer;
    }
}
