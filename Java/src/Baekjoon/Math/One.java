package Baekjoon.Math;

import java.math.BigInteger;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            BigInteger n = BigInteger.valueOf(sc.nextInt());
            BigInteger offset = BigInteger.valueOf(1);
            for(int i = 1; ; ++i, offset = offset.multiply(BigInteger.TEN).add(BigInteger.ONE)) {
                if(n.compareTo(offset) > 0) {
                    continue;
                }

                if(offset.remainder(n).equals(BigInteger.ZERO)) {
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}

