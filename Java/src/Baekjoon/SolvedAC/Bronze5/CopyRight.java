package Baekjoon.SolvedAC.Bronze5;

import java.util.Scanner;

public class CopyRight {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt(), I = sc.nextInt();
        // A * I : 최대 곡
        // 최소 곡 -> I가 올림 처리된 경우, 즉 A * (I - 1)에 최소 1개의곡
        System.out.println(A * (I - 1) + 1);
    }
}
