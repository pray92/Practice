package Utils;

import java.util.Scanner;

/**
 * 각종 사용하기 유용한 함수들을 리스트로 담음
 * 1. 소수 판별
 * 2. 최대 공약수/최소 공배수
 * 3. 실수 값 Equal
 */
public class Util {

    /**
     * 소수 여부를 판별합니다.
     * @param number
     * @return true if number is prime
     */
    public static boolean IsPrime(long number){
        if(number <= 2L) return false;
        for(long i = 2L; i <= (long)Math.sqrt(number) ; ++i){
            if(number % i == 0)
                return false;
        }
        return true;
    }

    /**
     * 두 수의 최대 공약수를 반환합니다
     * @param a
     * @param b
     * @return gcd of a & b
     */
    public static long gcd(int a, int b){
        while(b != 0){
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return Math.abs(a);
    }

    /**
     * 두 수의 최소 공배수를 반환합니다.
     * @param a
     * @param b
     * @return lcm of a & b
     */
    public static long lcm(int a, int b){
        return (a * (long)b) / gcd(a, b);
    }

    /**
     * 두 실수가 기준 값보다 차가 적은지 확인
     * 근사값 이슈로 인한 함수
     * @param a
     * @param b
     * @see IEEE 754
     * @return
     */
    public static boolean absoluteEqual(double a, double b){
        final double LIMIT = 1e-10;
        return Math.abs(a - b) < LIMIT;
    }


    public static void main(String[] args){
    }
}
