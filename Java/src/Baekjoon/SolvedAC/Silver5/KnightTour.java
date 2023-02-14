package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class KnightTour {

  private static final int[] A = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
  private static final int[] N = new int[] { -2, -1, 1, 2, 2, 1, -1, -2 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    boolean[] done = new boolean[36];

    List<String> routes = new ArrayList<String>();

    boolean isOverlapped = false;
    for (int i = 0; i < 36; ++i) {
      String route = br.readLine();
      int offset = (route.charAt(0) - 'A') * 6 + (route.charAt(1) - '1');
      if(done[offset]) {
        isOverlapped = true;
      }

      done[offset] = true;
      routes.add(route);
    }
    if(isOverlapped) {
      System.out.println("Invalid");
      return;
    }

    String cur = routes.get(0);
    if(false == isReachable(routes.get(routes.size() - 1), cur)) {
      System.out.println("Invalid");
      return;
    }

    for(int i = 1; i < routes.size(); ++i) {
      String next = routes.get(i);
      if(false == isReachable(cur, next)) {
        System.out.println("Invalid");
        return;
      }
      cur = next;
    }
    System.out.println("Valid");
  }

  private static boolean isReachable(String from, String to) {
    char a = from.charAt(0);
    char n = from.charAt(1);

    for(int i = 0; i < 8; ++i) {
      char toA = (char)(a + A[i]);
      char toN = (char)(n + N[i]);
      if(toA == to.charAt(0) && toN == to.charAt(1)) {
        return true;
      }
    }
    return false;
  }
}
