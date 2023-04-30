package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfDivisor {

    public static void main(String[] args) throws IOException {
        long[] sums = new long[1_000_001];
        Arrays.fill(sums,1);
        for(int i = 2; i < sums.length; ++i) {
            for(int j = 1; j * i < sums.length; ++j) {
                sums[j * i] += i;
            }
        }
        for(int i = 2; i < sums.length; ++i) {
            sums[i] += sums[i - 1];
        }

        StringBuilder ret = new StringBuilder();

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(sc.readLine());
        for(int i = 0; i < T; ++i) {
            int number = Integer.parseInt(sc.readLine());
            ret.append(sums[number]).append("\n");
        }
        System.out.println(ret);
    }
}
