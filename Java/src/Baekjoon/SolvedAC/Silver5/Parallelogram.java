package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Parallelogram {

  private static int X = 0;
  private static int Y = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    
    int[] A = new int[2];
    A[0] = Integer.parseInt(st.nextToken());
    A[1] = Integer.parseInt(st.nextToken());

    int[] B = new int[2];
    B[0] = Integer.parseInt(st.nextToken());
    B[1] = Integer.parseInt(st.nextToken());

    int[] C = new int[2];
    C[0] = Integer.parseInt(st.nextToken());
    C[1] = Integer.parseInt(st.nextToken());

    // 안되는 경우 -> 서로 직선 상
    if(isLinear(A, B, C)) {
      System.out.println(-1.0);
      return;
    }

    double AB = getDistance(A, B);
    double BC = getDistance(B, C);
    double AC = getDistance(A, C);

    double max = Double.MIN_VALUE;
    double min = Double.MAX_VALUE;
    // 2(AB + BC)
    double ret = 2.0 * (AB + BC);
    max = Math.max(ret, max);
    min = Math.min(ret, min);
    // 2(AC + BC)
    ret = 2.0 * (AC + BC);
    max = Math.max(ret, max);
    min = Math.min(ret, min);
    // 2(AB + AC)
    ret = 2.0 * (AB + AC);
    max = Math.max(ret, max);
    min = Math.min(ret, min);
    
    System.out.println(max - min);
  }
  
  private static boolean isLinear(int[] A,int[] B,int[] C) {
    return ((B[Y] - A[Y]) * (C[X] - B[X]) == (C[Y] - B[Y]) * (B[X] - A[X]));
  }

  private static double getDistance(int[] src, int[] dest) {
    return Math.sqrt(Math.pow(dest[Y] - src[Y], 2) + Math.pow(dest[X] - src[X], 2));
  }
}
