package Programmers;

import java.util.Arrays;

public class RotateMatrixEdge {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        int[][] tiles = new int[rows][columns];

        int value = 1;
        for(int y = 0; y < rows; ++y){
            for(int x = 0 ; x < columns; ++x){
                tiles[y][x] = value++;
            }
        }

        for(int i = 0; i < queries.length; ++i){
            int y1 = queries[i][0] - 1;
            int x1 = queries[i][1] - 1;
            int y2 = queries[i][2] - 1;
            int x2 = queries[i][3] - 1;

            // 1. 마지막 수를 캐싱
            int cachedLastValue = tiles[y1][x1];
            // 2. 역순으로 진행하여 위치 이동
            int y = y1, x = x1;
            // 2-1. 아래
            while(y < y2){
                tiles[y][x] = tiles[y + 1][x];
                answer[i] = Math.min(answer[i], tiles[y][x]);
                y++;
            }
            // 2-2. 우
            while(x < x2){
                tiles[y][x] = tiles[y][x + 1];
                answer[i] = Math.min(answer[i], tiles[y][x]);
                x++;
            }

            // 2-3. 위
            while(y > y1){
                tiles[y][x] = tiles[y - 1][x];
                answer[i] = Math.min(answer[i], tiles[y][x]);
                y--;
            }
            // 2-4. 좌
            while(x > x1){
                tiles[y][x] = tiles[y][x - 1];
                answer[i] = Math.min(answer[i], tiles[y][x]);
                x--;
            }
            // 3. 마지막으로 캐싱 값을 y, x + 1에 적재
            tiles[y][x + 1] = cachedLastValue;
            answer[i] = Math.min(answer[i], cachedLastValue);
        }

        return answer;
    }

    public static void main(String[] args){
        new RotateMatrixEdge().solution(6, 6, new int[][]{
                {2,2,5,4},
                {3,3,6,6},
                {5,1,6,3}
        });
    }
}
