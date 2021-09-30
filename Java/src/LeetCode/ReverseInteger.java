package LeetCode;

public class ReverseInteger {
    public int reverse(int x) {
        long answer = 0L;
        while(x != 0){
            answer = (answer * 10) + (x % 10);
            if(answer > Integer.MAX_VALUE || answer < Integer.MIN_VALUE)
                return 0;

            x /= 10;
        }

        return (int)answer;
    }

    public static void main(String[] args){
        int ans = new ReverseInteger().reverse(-2147483648);

    }
}
