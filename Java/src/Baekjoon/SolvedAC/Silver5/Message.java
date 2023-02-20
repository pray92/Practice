package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Message {
  public static void main(String[] args) throws IOException {
    List<String> answer = new ArrayList<String>();
    int grpCount = 1;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    while(input.compareTo("0") != 0) {
      answer.add(new StringBuilder("Group ").append(grpCount++).toString());

      int childCount = Integer.parseInt(input);
      
      List<String> children = new ArrayList<String>();
      int[][] nasty = new int[childCount][childCount - 1];
      for(int i = 0; i < childCount; ++i) {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        children.add(st.nextToken());
        for(int j = 1, k = 0; j < childCount; ++j) {
          if(st.nextToken().compareTo("P") == 0) {
            continue;
          }
          
          nasty[i][k++] = j;
        }
      }

      boolean isNasty = false;
      for(int i = 0; i < childCount; ++i) {
        String target = children.get(i);
        for(int j = 0; j < childCount - 1; ++j) {
          if(0 >= nasty[i][j]) {
            continue;
          }

          isNasty = true;

          int offset = i - nasty[i][j];
          if(0 > offset) {
            offset += childCount;
          }

          String source = children.get(offset);
          
          answer.add(
            new StringBuilder(source)
              .append(" was nasty about ")
              .append(target).toString()
          );
        }
      }
      if(!isNasty) {
        answer.add("Nobody was nasty");
      }
      answer.add("");

      input = br.readLine();
    }
    for(String ans : answer) {
      System.out.println(ans);
    }
  }
}
