package Baekjoon.SolvedAC.Bronze5;

import java.util.Scanner;

public class AfterParty {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int L = sc.nextInt(), P = sc.nextInt();
        int totalCnt = L * P;
        for(int nNewsIndex = 0 ; nNewsIndex < 5; ++nNewsIndex){
            System.out.print(sc.nextInt() - totalCnt);
            System.out.print(" ");
        }
    }
}
