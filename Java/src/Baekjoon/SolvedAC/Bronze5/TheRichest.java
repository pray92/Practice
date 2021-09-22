package Baekjoon.SolvedAC.Bronze5;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * BigInteger의 존재를 알 수 있었음
 */
public class TheRichest {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        BigInteger n, m;
        n = sc.nextBigInteger();
        m = sc.nextBigInteger();
        BigInteger[] ans = n.divideAndRemainder(m);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
    }
}
