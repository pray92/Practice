package Programmers;

import java.util.Arrays;

public class ArcheryCompetition {

    private final boolean DEBUG = true;

    private final int SCORE = 11;
    private int[] answer = { -1 }; 
    private int highestScoreGap = 0;

    // n : 화살 개수, info : 어피치가 맞친 과녁
    public int[] solution(int n, int[] info) {
        int[] lionInfo = new int[SCORE];
        dfs(n, info, 0, lionInfo);
        return answer;
    }

    private void dfs(int n, int[] info, int lionN, int[] lionInfo){
        if(n <= lionN){
            setResult(lionInfo, info);
            return;
        }

        for(int i = 0; i < SCORE; ++i){
            if(info[i] < lionInfo[i]){
                continue;
            }
            ++lionInfo[i];
            dfs(n, info, lionN + 1, lionInfo);
            --lionInfo[i];
        }
    }

    void setResult(int[] lion, int[] apeach) {
        int lionScore = 0, apeachScore = 0;
        for(int i = 0; i < SCORE - 1; ++i){
            if(lion[i] == 0 && apeach[i] == 0){
                continue;
            } 

            if(lion[i] > apeach[i]){
                lionScore += (10 - i);
            } else{
                apeachScore += (10 - i);
            }
        }

        if(lionScore > apeachScore){
            if(highestScoreGap < (lionScore - apeachScore)){
                answer = Arrays.copyOf(lion, lion.length);
                highestScoreGap = (lionScore - apeachScore);

                if(DEBUG){
                    System.out.println("Lion shot : " + Arrays.toString(answer));   
                }
            } else if(highestScoreGap == (lionScore - apeachScore)){
                boolean isChange = false;
                for(int i = SCORE - 1; i >= 0; --i){
                    if(lion[i] > answer[i]){
                        isChange = true;
                        break;
                    }
                }
                if(isChange){
                    answer = Arrays.copyOf(lion, lion.length);
                }

                if(DEBUG){
                    System.out.println("Lion shot : " + Arrays.toString(answer));   
                }
            }
        }
    }

    public static void main(String[] args){
        new ArcheryCompetition().solution(10, new int[]{ 0,0,0,0,0,0,0,0,3,4,3 });
        //new ArcheryCompetition().solution(1, new int[]{ 1,0,0,0,0,0,0,0,0,0,0});
    }
}
