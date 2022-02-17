package Programmers;

public class CandidateKey {
    public int solution(String[][] relation) {
        int answer = 0;


        for(int left = 0, right = 0; right < relation[0].length;){
            if (IsUnique(relation, left, right)) {
                ++answer;
                left = ++right;
            } else{
                ++right;
            }
        }

        return answer;
    }

    private boolean IsUnique(String[][] relation, int left, int right) {
        int rowCnt = relation.length;
        for(int nRow1 = 0; nRow1 < rowCnt; ++nRow1){
            for(int nRow2 = nRow1 + 1; nRow2 < rowCnt; ++nRow2){
                boolean isUnique = false;
                for(int nCol = left; nCol <= right; ++nCol){
                    if(relation[nRow1][nCol].compareTo(relation[nRow2][nCol]) != 0){
                        isUnique = true;
                    }
                }
                if(!isUnique) {
                    return false;
                }
            }
        }
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
