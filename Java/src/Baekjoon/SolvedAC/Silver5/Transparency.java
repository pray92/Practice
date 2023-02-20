package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Transparency {
  public static void main(String[] args) throws IOException {
    int[][] panel = new int[101][101];

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    for(int i = 0; i < N; ++i) {
      st = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());
      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      for(int y = y1; y <= y2; ++y) {
        for(int x = x1; x <= x2; ++x) {
          panel[y][x]++;
        }
      }
    }

    int answer = 0;
    for(int y = 1; y <= 100; ++y) {
      for(int x = 1; x <= 100; ++x) {
        if(M >= panel[y][x]) {
          continue;
        }
        ++answer;
      }
    }

    System.out.println(answer);
  }
}
