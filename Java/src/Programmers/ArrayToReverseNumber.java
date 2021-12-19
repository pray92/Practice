package Programmers;

import java.util.ArrayList;
import java.util.List;

public class ArrayToReverseNumber {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>(21);
        while(n != 0){
            list.add((int) (n % 10));
            n /= 10;
        }
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size(); ++i){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
