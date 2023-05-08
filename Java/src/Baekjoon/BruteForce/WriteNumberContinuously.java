package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WriteNumberContinuously {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int offsetNumber = 10, times = 1; ; offsetNumber *= 10, ++times) {
            if(N >= offsetNumber) {
                answer += (offsetNumber - offsetNumber / 10) * times;
                if(N == offsetNumber) {
                    answer += (times + 1);
                    break;
                }
            } else {
                answer += (N - (offsetNumber / 10) + 1) * times;
                break;
            }
        }

        System.out.println(answer);
    }
}
