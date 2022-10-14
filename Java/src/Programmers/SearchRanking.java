package Programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class SearchRanking {

    private final static String NONE = "-";


    public int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        
        List<String[]> appliers = new ArrayList<String[]>();
        for(String info : infos) {
            appliers.add(info.split(" "));
        }
        Collections.sort(appliers, (x, y) -> Integer.parseInt(x[4]) - Integer.parseInt(y[4]));

        for(int index = 0; index < queries.length; ++index) {
            int ret = 0;
            
            String[] parsed = parseQuery(queries[index]);
            int minScore = Integer.parseInt(parsed[7]);

            int left = 0, right = appliers.size() - 1;
            while(left <= right) {

                int mid = (left + right) >> 1;
                int score = Integer.parseInt(appliers.get(mid)[4]); 
                if(score >= minScore) {
                    int ret2 = 0;
                    for(String[] applier : appliers) {
                        if(isSatisfy(applier, parsed)) {
                            ++ret2;
                        }
                    }
                    ret = Math.max(ret, ret2);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            answer[index] = ret;
        }

        return answer;
    }

    static boolean isSatisfy(String[] applier, String[] parsed) {
        if(false == parsed[0].equals(NONE) && false == applier[0].equals(parsed[0])) {
            return false;
        }
        if(false == parsed[2].equals(NONE) && false == applier[1].equals(parsed[2])) {
            return false;
        }
        if(false == parsed[4].equals(NONE) && false == applier[2].equals(parsed[4])) {
            return false;
        }
        if(false == parsed[6].equals(NONE) && false == applier[3].equals(parsed[6])) {
            return false;
        }
        if(Integer.parseInt(applier[4]) < Integer.parseInt(parsed[7])) {
            return false;
        }

        return true;
    }

    static String[] parseQuery(String query) {
        String[] parsed = query.split(" ");

        return parsed;
    }

    public static void main(String args[]) {
        new SearchRanking().solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
         new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});
    }
}
