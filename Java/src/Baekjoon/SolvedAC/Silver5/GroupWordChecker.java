package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroupWordChecker {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    int ret = 0;      
    for (int i = 0; i < T; ++i) {
      boolean[] alphabet = new boolean['z' + 1];

      String word = br.readLine();

      boolean isGroupWord = true;
      char prev = word.charAt(0);
      alphabet[prev] = true;
      for(int j = 1; j < word.length(); ++j) {
        char cur = word.charAt(j);
        if(prev != cur) {
          if(false == alphabet[cur]) {
            alphabet[cur] = true;
          } else {
            isGroupWord = false;
            break;
          }
        } 
        prev = cur;
      }
      if(isGroupWord) {
        ++ret;
      }
    }
    System.out.println(ret);
  }
}
