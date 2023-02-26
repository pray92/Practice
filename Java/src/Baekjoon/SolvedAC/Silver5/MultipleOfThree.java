package Baekjoon.SolvedAC.Silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MultipleOfThree {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String strNumber = br.readLine();
    int number = getNumber(strNumber);
    if(Integer.toString(number).compareTo(strNumber) == 0) {
      System.out.println(0);
      System.out.println((number != 0 && number % 3 == 0) ? "YES" : "NO");
      return;
    }

    int count = 1;
    while(10 <= number) {
      number = getNumber(Integer.toString(number));
       ++count;
    }
    
    System.out.println(count);
    System.out.println((number != 0 && number % 3 == 0) ? "YES" : "NO");
  }

  private static int getNumber(String strNumber) {
    int ret = 0;
    for(int i = 0 ; i < strNumber.length(); ++i) {
      ret += (strNumber.charAt(i) - '0');
    }
    return ret;
  }
}
