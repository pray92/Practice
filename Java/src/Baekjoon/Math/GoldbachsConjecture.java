package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GoldbachsConjecture {
    private static boolean[] primes = new boolean[1_000_001];

    public static void main(String[] args) throws IOException {
        updatePrimes();

        StringBuilder ret = new StringBuilder();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        while(0 != (n = Integer.parseInt(br.readLine()))){
            int b = getMaxB(n);
            if(0 >= b) {
                ret.append("Goldbach's conjecture is wrong.\n");
                continue;
            }
            int a = n - b;
            ret.append(n).append(" = ").append(a).append(" + ").append(b).append("\n");
        }
        System.out.println(ret.toString());
    }

    private static void updatePrimes() {
        Arrays.fill(primes, true);
        primes[1] = false;
        for(int i = 2; i <= 1_000; ++i) {
            if(false == primes[i]) {
                continue;
            }

            for(int j = i + i; j <= 1_000_000; j += i) {
                primes[j] = false;
            }
        }
        primes[2] = false;
    }

    private static int getMaxB(int n) {
        for(int i = n - 1; i > 2; --i) {
            if(i % 2 != 0 && primes[i] && primes[n - i]) {
                return i;
            }
        }
        return 0;
    }
}
