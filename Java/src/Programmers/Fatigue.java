
package Programmers;

// 22:07 ~
public class Fatigue {

    private int answer = 0;
    private boolean[] done = null;

    public int solution(int k, int[][] dungeons) {
        answer = 0;
        done = new boolean[dungeons.length];

        for(int i = 0; i < dungeons.length; ++i){
            if(k < dungeons[i][0]){
                continue;
            }

            done[i] = true;
            dfs(dungeons, k - dungeons[i][1], 1);
            done[i] = false;
        }

        return answer;
    }

    private void dfs(int[][] dungeons, int k, int count){
        answer = Math.max(answer, count);

        for(int i = 0; i < dungeons.length; ++i){
            if(done[i] || k < dungeons[i][0]){
                continue;
            }

            done[i] = true;
            dfs(dungeons, k - dungeons[i][1], count + 1);
            done[i] = false;
        }
    }

    public static void main(String[] args){
        var ret = new Fatigue().solution(2, new int[][]{
            new int[] {1, 2},
            new int[] {2, 3},
        });
    }
}

