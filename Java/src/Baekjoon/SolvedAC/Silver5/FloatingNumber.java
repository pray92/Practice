package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloatingNumber {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int n = 0;
    int a = A;
    while (a < B && n < N) {
      a *= 10;
      ++n;
    }

    int ret = 0;
    if (n == N) {
      ret = (a < B) ? 0 : a / B;
    } else if (n < N) {
      for (int i = n; i <= N; ++i) {
        if (a < B) {
          a *= 10;
          ret = 0;
        } else {
          ret = a / B;
          a = (a % B) * 10;
        }
      }
    }
    System.out.println(ret);
  }
}
