package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {
    private static int n = 0;
    private static char[][] candyMap = null;
    private static int my[] = {0, 0, 1, -1};
    private static int mx[] = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        candyMap = new char[n][n];
        for(int y = 0 ; y < n; ++y) {
            String row = br.readLine();
            for(int x= 0 ; x < n ; ++x) {
                candyMap[y][x] = row.charAt(x);
            }
        }

        int answer = 0;
        for(int y = 0 ; y < n; ++y) {
            for(int x= 0 ; x < n ; ++x) {
                answer = Math.max(answer, getMaxCandies(y, x));
            }
        }
        System.out.println(answer);
    }

    private static int getMaxCandies(int cy, int cx) {
        int ret = 0;

        char srcClr = candyMap[cy][cx];
        for(int nAxis = 0; nAxis < 4; ++nAxis) {
            int y = cy + my[nAxis];
            int x = cx + mx[nAxis];
            if(y < 0 || y >= n || x < 0 || x >= n) {
                continue;
            }

            char destClr = candyMap[y][x];

            swap(cy, cx, y, x);

            int value = 1;

            int left = x - 1;
            while(left >= 0 && srcClr == candyMap[y][left--]) { ++value; }

            int right = x + 1;
            while(right < n && srcClr == candyMap[y][right++]) { ++value; }

            ret = Math.max(ret, value);

            value = 1;

            int top = y - 1;
            while(top >= 0 && srcClr == candyMap[top--][x]) { ++value; }

            int bottom = y + 1;
            while(bottom < n && srcClr == candyMap[bottom++][x]) { ++value; }

            ret = Math.max(ret, value);

            swap(cy, cx, y, x);
        }

        return ret;
    }

    private static void swap(int srcY, int srcX, int destY, int destX) {
        char tmp = candyMap[srcY][srcX];
        candyMap[srcY][srcX] = candyMap[destY][destX];
        candyMap[destY][destX] = tmp;
    }

}
