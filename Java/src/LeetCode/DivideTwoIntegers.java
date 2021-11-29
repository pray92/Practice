package LeetCode;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long dividend2 = dividend;
        boolean isDividendMinus = dividend < 0;
        if(isDividendMinus)
            dividend2 = -dividend2;

        long divisor2 = divisor;
        boolean isDivisorMinus = divisor < 0;
        if(isDivisorMinus)
            divisor2 = -divisor2;

        long ret = 0;
        while(divisor2 <= dividend2){
            int mask;
            for(mask = 0; mask <= 30; ++mask){
                if((divisor2 << (mask + 1)) > dividend2)
                    break;
            }

            ret += (1L << mask);
            dividend2 -= (divisor2 << mask);
        }

        if((isDividendMinus && !isDivisorMinus) || (!isDividendMinus && isDivisorMinus)){
            if(-ret < Integer.MIN_VALUE)
                ret = (Integer.MIN_VALUE + 1);
            return (int)-ret;
        }

        if(ret > Integer.MAX_VALUE)
            ret = Integer.MAX_VALUE;

        return (int)ret;
    }

    public static void main(String[] args){
        new DivideTwoIntegers().divide(-2147483648, -1);
        new DivideTwoIntegers().divide(7, -3);

        //System.out.println((1L << 31) + " " + Integer.MAX_VALUE);
    }

}
