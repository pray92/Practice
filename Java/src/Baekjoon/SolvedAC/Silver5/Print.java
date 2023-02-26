package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Print {
  private static final char DOT = '.';
  private static final char VERT = '|';
  private static final char HORZ = '-';
  private static final char BOTH = '+';

  private static final int[] moveX = new int[] { 0, 0, -1, 1 };
  private static final int[] moveY = new int[] { 1, -1, 0, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    char[][] panel = new char[N][N];
    
    String routes = br.readLine();

    int curX = 0, curY = 0;
    for(int i = 0; i < routes.length(); ++i) {
      char route = routes.charAt(i);
      int m = getMoveIndex(route);

      int nextX = curX + moveX[m];
      int nextY = curY + moveY[m];
      if(0 > nextX || N <= nextX
      || 0 > nextY || N <= nextY) {
        continue;
      }

      char draw = (m < 2) ? VERT : HORZ;
      panel[curY][curX] = getDraw(panel, curX, curY, draw);
      panel[nextY][nextX] = getDraw(panel, nextX, nextY, draw);

      curX = nextX;
      curY = nextY;
    }
    for(int i = 0; i < N; ++i) {
      for(int j = 0; j < N; ++j) {
        System.out.print((panel[i][j] != '\0') ? panel[i][j] : '.');
      }
      System.out.println();
    }
  }

  static int getMoveIndex(char m) {
    switch(m) {
      case 'D': return 0;
      case 'U': return 1;
      case 'L': return 2;
      default: return 3;
    }
  }

  static char getDraw(char[][] panel, int x, int y, char draw) {
    if(panel[y][x] != '\0' && draw != panel[y][x]) {
      return BOTH;
    } 
    return draw;
  }
}
