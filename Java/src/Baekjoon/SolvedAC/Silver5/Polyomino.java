package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Polyomino {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String board = br.readLine();

    StringBuilder sb = new StringBuilder();
    for(int i = 0, count = 0; i < board.length(); ++i) {
      char b = board.charAt(i);
      if(b == '.') {
        if(0 < count) {
          int divA = (count / 4);
          for(int j = 0; j < divA; ++j) {
            sb.append("AAAA");
          }
          count %= 4;
          if(count % 2 != 0) {
            System.out.println(-1);
            return;
          }
          int divB = (count / 2);
          for(int j = 0; j < divB; ++j) {
            sb.append("BB");
          }
        }
        count = 0;
        sb.append(b);
      } else {
        ++count;
      }
      if(i == board.length() - 1) {
        if(0 < count) {
          int divA = (count / 4);
          for(int j = 0; j < divA; ++j) {
            sb.append("AAAA");
          }
          count %= 4;
          if(count % 2 != 0) {
            System.out.println(-1);
            return;
          }
          int divB = (count / 2);
          for(int j = 0; j < divB; ++j) {
            sb.append("BB");
          }
        }
        count = 0;
      }
    }
    System.out.println(sb.toString());
  }
}
