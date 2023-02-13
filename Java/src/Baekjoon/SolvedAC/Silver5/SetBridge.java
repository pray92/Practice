package Baekjoon.SolvedAC.Silver5;

import java.util.Scanner;

public class SetBridge {

  public static void main(String[] args) {
    int[][] dp = new int[30][30];
    for(int i = 1; i < 30; ++i) {
      dp[i][i] = 1;
      dp[i][0] = 1;
    }
    for(int i = 2; i < 30; ++i) {
      for(int j = 1; j < 30; ++j) {
        dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
      }
    }


    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();

    for (int i = 0; i < T; ++i) {
      int N = sc.nextInt();
      int M = sc.nextInt();
      System.out.println(dp[M][N]);
    }
  }
}
