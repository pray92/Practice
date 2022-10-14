package Programmers;

import java.util.List;

public class CandidateKey {

    private static String[][] relationShip = null;

    public int solution(String[][] relation) {
        relationShip = relation;

        int answer = 0;

        

        return answer;
    }

    private boolean isUnique(String[][] relation, List<Integer> candidateColumns) {
        

        return true;
    }

    public static void main(String[] args){
        var ret = new CandidateKey().solution(new String[][]{
        new String[]{"100", "ryan", "music", "2"},
        new String[]{"200", "apeach", "math", "2"},
        new String[]{"300", "tube", "computer", "3"},
        new String[]{"400", "con", "computer", "4"},
        new String[]{"500", "muzi", "music", "3"},
        new String[]{"600", "apeach", "music", "2"}});
    }
}
