package LeetCode;

import java.util.StringJoiner;

// 21:24
public class StringToInteger {
    public int myAtoi(String s) {
        long answer = 0;
        boolean isPositive = true, fixed = false;
        for(int nIndex = 0; nIndex < s.length(); ++nIndex){
            char chr = s.charAt(nIndex);
            if(chr == ' '){
                if(fixed)
                    break;
                continue;
            }
            if(chr == '+'){
                if(fixed)
                    break;
                fixed = true;
            }
            else if(chr == '-'){
                if(fixed)
                    break;
                isPositive = false;
                fixed = true;
            }
            else if('0' <= chr && chr <= '9'){
                fixed = true;
                answer = (answer * 10) + (chr - '0');
                if(answer > Integer.MAX_VALUE){
                    return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            else{
                break;
            }
        }
        if(!isPositive)
            answer *= -1L;
        return (int)answer;
    }

    public static void main(String[] args){
        int ans = new StringToInteger().myAtoi("42");
    }

}
