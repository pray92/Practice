package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long number = Long.parseLong(br.readLine());

    long sum = 0L, answer = 0;
    for (long i = 1; sum <= number; ++i) {
      sum += i;
      ++answer;
    }
    System.out.println(answer - 1);
  }
}
