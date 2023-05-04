package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tetromino {
    private static int[][] panel = null;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] lines = br.readLine().split(" ");
        int N = Integer.parseInt(lines[0]);
        int M = Integer.parseInt(lines[1]);
        panel = new int[N][M];
        for(int y = 0; y < N; ++y) {
            String[] row = br.readLine().split(" ");
            for(int x = 0; x < M; ++x) {
                panel[y][x] = Integer.parseInt(row[x]);
            }
        }

        int answer = getMaxValue(new int[]{0, 0, 0, 0}, new int[]{0, 1, 2, 3});
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 2, 3}, new int[]{0, 0, 0, 0}));

        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 1, 1}, new int[]{0, 1, 0, 1}));

        // 회전
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 2, 2}, new int[]{0, 0, 0, 1}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 0}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 1, 2}, new int[]{0, 1, 1, 1}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 1}, new int[]{2, 0, 1, 2}));
        // 대칭
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 2, 2}, new int[]{1, 1, 1, 0}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 1}, new int[]{0, 0, 1, 2}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 1, 2}, new int[]{0, 1, 0, 0}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 2}));

        // 회전
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 1}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 1, 1}, new int[]{1, 2, 0, 1}));
        // 대칭
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 2}, new int[]{1, 0, 1, 0}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 1, 1}, new int[]{0, 1, 1, 2}));

        answer = Math.max(answer, getMaxValue(new int[]{0, 0, 0, 1}, new int[]{0, 1, 2, 1}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 2}, new int[]{1, 0, 1, 1}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 1}, new int[]{1, 0, 1, 2}));
        answer = Math.max(answer, getMaxValue(new int[]{0, 1, 1, 2}, new int[]{0, 0, 1, 0}));

        System.out.println(answer);
    }

    private static int getMaxValue(int[] checkY, int[] checkX) {
        int ret = 0;

        for(int y = 0; y < panel.length; ++y) {
            for(int x = 0; x < panel[y].length; ++x) {
                try {
                    int value = 0;
                    for(int i = 0; i < 4; ++i) {
                        value += panel[y + checkY[i]][x + checkX[i]];
                    }
                    ret = Math.max(ret, value);
                } catch (ArrayIndexOutOfBoundsException e) {
                    continue;
                }
            }
        }

        return ret;
    }
}
