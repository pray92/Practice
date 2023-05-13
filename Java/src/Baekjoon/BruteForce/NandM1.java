package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NandM1 {
    private static List<int[]> answers = new ArrayList<int[]>(8 * 7 * 6 * 5 * 4 * 3 * 2);

    private static boolean[] done = new boolean[8 + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().split(" ");
        int N = Integer.parseInt(values[0]), M = Integer.parseInt(values[1]);

        getPermutations(N, M, 0, new int[M]);

        for(int[] answer : answers) {
            for(int value : answer) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    private static void getPermutations(int N, int M, int index, int[] permutation) {
        if(M <= index) {
            int[] answer = new int[M];
            System.arraycopy(permutation, 0, answer, 0, M);
            answers.add(answer);
            return;
        }

        for(int i = 1; i <= N; ++i) {
            if(done[i]) {
                continue;
            }
            done[i] = true;
            permutation[index] = i;
            getPermutations(N, M, index + 1, permutation);
            done[i] = false;
        }
    }
}
