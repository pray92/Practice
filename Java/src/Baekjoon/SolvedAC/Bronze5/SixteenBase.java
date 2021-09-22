package Baekjoon.SolvedAC.Bronze5;

import java.util.Scanner;

/**
 * Integer 클래스의 존재
 */
public class SixteenBase {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String value = sc.next();
        System.out.println(Integer.parseInt(value, 16));
    }
}
