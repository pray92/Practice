package Programmers;

import java.util.Arrays;

public class Hopscotch {

    private final int MAX_TILE = 4;

    int solution(int[][] land) {
        for(int i = 0; i < land.length - 1; ++i){
            for(int j = 0; j < MAX_TILE; ++j){
                land[i + 1][j] += getMax(land[i], j);
            }
        }

        int answer = getMax(land[land.length -1], -1);
        return answer;
    }

    private int getMax(int[] tiles, int ignore){
        int maxValue = -1;
        for(int i = 0; i < MAX_TILE; ++i){
            if(i == ignore){
                continue;
            }

            maxValue = Math.max(maxValue, tiles[i]);
        }
        return maxValue;
    }

    public static void main(String[] args){
        var ret =new Hopscotch().solution(new int[][]
                {
                        new int[]{1,2,3,5},
                        new int[]{5,6,7,8},
                        new int[]{4,3,2,1},
                });
    }
}
