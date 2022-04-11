package Programmers;

import java.util.ArrayDeque;
import java.util.Arrays;

// 22:06
public class LifeBoat {

    final int MAX_WEIGHT = 240;
    // 2명밖에 못탐, 무게 제한 있음
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        
        ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
        for(int person : people){
            dq.add(person);
        }

        while(false == dq.isEmpty()){
            int weight = dq.pollLast();
            if(false == dq.isEmpty() && weight + dq.peekFirst() <= limit){
                dq.pollFirst();
            }
            ++answer;
        }

        return answer;
    }    

    public static void main(String[] args){
        System.out.println(new LifeBoat().solution(new int[]{
            70, 50 ,80
        }, 
        100));
    }
}
