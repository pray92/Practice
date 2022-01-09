package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoFriendsColoringBook {

    private boolean[][] done = null;
    private final int[] mY = new int[]{-1, 1, 0, 0};
    private final int[] mX = new int[]{0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        done = new boolean[m][n];

        for(int y = 0; y < m; ++y){
            for(int x = 0; x < n; ++x){
                if(!done[y][x] && 0 != picture[y][x]){
                    int sizeOfOneArea = getSizeOfOneArea(m, n, y, x, picture);
                    ++numberOfArea;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfOneArea);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private class AreaInfo{
        public int y;
        public int x;

        public AreaInfo(int y, int x){
            this.y = y;
            this.x = x;
        }
    }

    private int getSizeOfOneArea(int y, int x, int curY, int curX, int[][] picture){
        int size = 0;
        done[curY][curX] = true;
        int pixel = picture[curY][curX];
        Queue<AreaInfo> queue = new LinkedList<>();
        queue.add(new AreaInfo(curY, curX));
        while(!queue.isEmpty()){
            AreaInfo info = queue.poll();
            ++size;

            for(int i = 0; i < 4; ++i){
                int moveY = info.y + mY[i];
                int moveX = info.x + mX[i];
                if(0 <= moveY && moveY < y && 0 <= moveX && moveX < x)
                {
                    if(!done[moveY][moveX] && picture[moveY][moveX] == pixel){
                        done[moveY][moveX] = true;
                        queue.add(new AreaInfo(moveY, moveX));
                    }
                }
            }
        }

        return size;
    }

    public static void main(String[] args){
        var answer = new KakaoFriendsColoringBook().solution(6, 4,
                new int[][]{
                        {1, 1, 1, 0},
                        {1, 2, 2, 0},
                        {1, 0, 0, 1},
                        {0, 0, 0, 1},
                        {0, 0, 0, 3},
                        {0, 0, 0, 3}
                });
        System.out.println(Arrays.toString(answer));
    }

}
