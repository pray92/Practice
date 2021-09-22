package Baekjoon.SolvedAC.Bronze5;

import java.util.Scanner;

public class Chess {

    private static int[] chessCnt = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int nChessIndex = 0 ; nChessIndex < chessCnt.length; ++nChessIndex){
            System.out.print(chessCnt[nChessIndex] - sc.nextInt());
            System.out.print(" ");
        }
    }
}
