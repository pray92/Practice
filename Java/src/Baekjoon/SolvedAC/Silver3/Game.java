package Baekjoon.SolvedAC.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Game {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer( br.readLine(), " ");
    long X = Long.parseLong(st.nextToken());
    long Y = Long.parseLong(st.nextToken());
    if(X == Y) {
      System.out.println(-1);
      return;
    }
    long Z = (Y * 100) / X;

    long answer = -1;
    long left = 0, right = 1_000_000_000;
    while(left <= right) {
      long n = (left + right) >>> 1;
      
      long z = ((Y + n) * 100) / (X + n);
      if(z > Z) {
        answer = n;
        right = n - 1;
      } else {
        left = n + 1;
      }
    }
    System.out.println(answer);
  }
}
