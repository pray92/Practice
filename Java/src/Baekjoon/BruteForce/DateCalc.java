package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DateCalc {
    private static final int MAX_E = 15;
    private static final int MAX_S = 28;
    private static final int MAX_M = 19;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int E = Integer.parseInt(line[0]);
        int S = Integer.parseInt(line[1]);
        int M = Integer.parseInt(line[2]);

        int e = 1;
        int s = 1;
        int m = 1;

        int ret = 1;
        while(E != e || S != s || M != m) {
            e = Math.max( ++e % (MAX_E + 1), 1);
            s = Math.max( ++s % (MAX_S + 1), 1);
            m = Math.max( ++m % (MAX_M + 1), 1);

            ++ret;
        }

        System.out.println(ret);
    }
}
