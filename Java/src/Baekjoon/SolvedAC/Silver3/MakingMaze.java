package Baekjoon.SolvedAC.Silver3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

class Position {
  public int x = 0;
  public int y = 0;

  public Position(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if(false == o instanceof Position){
      return false;
    }
    return ((Position)o).x == this.x && ((Position)o).y == this.y;
  }

  @Override
  public int hashCode() {
    return (this.x + this.y * 100);
  }
}

public class MakingMaze {
  private static int[] X = new int[] { 0, 1, 0, -1 };
  private static int[] Y = new int[] { -1, 0, 1, 0 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String routes = br.readLine();

    Set<Position> positions = new HashSet<Position>();

    int minX = 0, minY = 0, maxX = 0, maxY = 0;
    positions.add(new Position(0, 0));

    int move = 0;
    int curX = 0, curY = 0;
    for (int i = 0; i < routes.length(); ++i) {
      char route = routes.charAt(i);
      switch (route) {
        case 'L':
          move = (move + 1 < 4) ?  move + 1 : 0;
          break;
        case 'R':
          move = (move - 1 >= 0) ?  move - 1 : 3; 
          break;
        case 'F':
          curX += X[move];
          minX = Math.min(minX, curX);
          maxX = Math.max(maxX, curX);

          curY += Y[move];
          minY = Math.min(minY, curY);
          maxY = Math.max(maxY, curY);

          positions.add(new Position(curX, curY));
          break;
      }
    }
    for(int y = maxY; y >= minY; --y) {
      for(int x = minX; x <= maxX; ++x) {
        if(positions.contains(new Position(x, y))) {
          System.out.print('.');
        } else {
          System.out.print('#');
        }
      }
      System.out.println();
    }
  }
}
