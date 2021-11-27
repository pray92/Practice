package LeetCode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        boolean isDividendMinus = dividend < 0;
        if(isDividendMinus){
            if(dividend == Integer.MIN_VALUE){
                dividend += 1;
            }
            dividend = -dividend;
        }
        boolean isDivisorMinus = divisor < 0;
        if(isDivisorMinus){
            if(divisor == Integer.MIN_VALUE){
                divisor += 1;
            }
            divisor = -divisor;
        }

        int ret = 0;

        if((isDividendMinus && !isDivisorMinus)
        ||(!isDividendMinus && isDivisorMinus))
            return -ret;

        return ret;
    }

    public static void main(String[] args){
        new DivideTwoIntegers().divide(-2147483648, -1);
    }

}
