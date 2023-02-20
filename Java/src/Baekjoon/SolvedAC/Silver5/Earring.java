package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Earring {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    List<String> answer = new ArrayList<String>();

    int scenarioNumber = 1;
    String input = br.readLine();
    while (input.compareTo("0") != 0) {
      // 1. 사람 수
      int count = Integer.parseInt(input);
      // 2. 사람
      boolean[][] done = new boolean[count + 1][2];
      List<String> people = new ArrayList<String>();
      people.add("");
      for (int i = 0; i < count; ++i) {
        people.add(br.readLine());
      }
      // 3. 이어링 목록(2 * 사람 수 - 1)
      for (int i = 0; i < 2 * count - 1; ++i) {
        input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int personNumber = Integer.parseInt(st.nextToken());
        String earringNumber = st.nextToken();
        switch(earringNumber) {
          case "A": done[personNumber][0] = true; break;
          case "B": done[personNumber][1] = true; break;
        }
      }

      for(int i = 1; i <= count; ++i) {
        if(done[i][0] && done[i][1]) {
          continue;
        }

        answer.add(
          new StringBuilder()
            .append(scenarioNumber++)
            .append(" ")
            .append(people.get(i)).toString()
        );

        break;
      }

      input = br.readLine();
    }
    for(String a : answer) {
      System.out.println(a);  
    }
  }
}
