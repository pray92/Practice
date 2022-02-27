package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tuple {

    private boolean[] done = new boolean[1_000_001];

    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<Integer>();

        s = s.substring(1, s.length() - 1);
        String[] tuples = s.split("},|}");
        int[][] tuplesToInt = new int[tuples.length][];
        for(int i = 0 ; i < tuples.length; ++i){
            int[] ans = getTuple(tuples[i]);
            tuplesToInt[i] = ans;
        }   
        
        Arrays.sort(tuplesToInt, (x, y) -> x.length - y.length);
        
        for(int i = 0 ; i < tuplesToInt.length; ++i){
            for(int j = 0;  j < tuplesToInt[i].length; ++j){
                if(done[tuplesToInt[i][j]]){
                    continue;
                }
                answer.add(tuplesToInt[i][j]);
                done[tuplesToInt[i][j]] = true;
            }
        }

        int[] answer2 = new int[answer.size()];
        for(int  i = 0 ; i < answer2.length; ++i){
            answer2[i] = answer.get(i);
        }

        return answer2;
    }

    private int[] getTuple(String tuple){
        tuple = tuple.substring(1, tuple.length());
        String[] elements = tuple.split(",");
        int[] ret = new int[elements.length];
        for(int i = 0; i < elements.length; ++i){
            ret[i] = Integer.parseInt(elements[i]);
        }
        return ret;
    }

    public static void main(String[] args){
        new Tuple().solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
    }
}
