package Baekjoon.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SevenDwarves {
    public static void main(String[] args) throws IOException {
        int[] dwarves = new int[9];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0 ; i < dwarves.length; ++i) {
            dwarves[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < dwarves.length - 1; ++i) {
            for(int j = i + 1; j < dwarves.length; ++j) {

                int ret = 0;
                for(int k = 0; k < dwarves.length; ++k) {
                    if(i == k || j == k) {
                        continue;
                    }
                    ret += dwarves[k];
                    if(100 < ret) {
                        break;
                    }
                }
                if(ret != 100) {
                    continue;
                }

                List<Integer> answer = new ArrayList<Integer>(7);
                for(int k = 0; k < dwarves.length; ++k) {
                    if(i == k || j == k) {
                        continue;
                    }
                    answer.add(dwarves[k]);
                }
                answer.stream().sorted().forEach(x -> System.out.println(x));
                return;
            }
        }
    }
}
