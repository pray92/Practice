package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitWord {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String word = br.readLine();

    String ret = word;
    for(int a = 1; a < word.length() - 1; ++a) {
      for(int b = a + 1; b < word.length(); ++b) {
        StringBuilder sb = reverse(word.substring(0, a))
                            .append(reverse(word.substring(a, b)))
                            .append(reverse(word.substring(b)));
        
        ret = (ret.compareTo(sb.toString()) < 0) ? ret : sb.toString();
      }
    }
    System.out.println(ret);
  }

  private static StringBuilder reverse(String word) {
    StringBuilder sb = new StringBuilder();
    for(int i  = word.length() - 1; i >= 0; --i) {
      sb.append(word.charAt(i));
    }
    return sb;
  }
}
