package Baekjoon.SolvedAC.Bronze5;

import java.util.Scanner;

public class ValidCount {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        for(int nCnt = 0; nCnt < 5; ++nCnt){
            int value = sc.nextInt();
            answer += Math.pow(value, 2);
        }
        System.out.println(answer % 10);
    }
}
