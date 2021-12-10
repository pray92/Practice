package LeetCode;

import java.util.Stack;

public class LongestVaildParentheses {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        int ret = 0, left = 0, right = 0;
        // Left
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            } else{
                right++;
            }
            if(left == right){
                ret = Math.max(ret, left + right);
            } else if(right >= left){
                left = right = 0;
            }
        }
        // Right
        left = 0; right = 0;
        for(int i = s.length() - 1; i >= 0; --i){
            char c = s.charAt(i);
            if(c == '('){
                left++;
            } else{
                right++;
            }
            if(left == right){
                ret = Math.max(ret, left + right);
            } else if(left >= right){
                left = right = 0;
            }
        }

        return ret;
    }
    /*
    public int longestValidParentheses(String s) {
        for(int i = 0; i <= s.length() - 2; ++i){
            for(int j = 0; j <= i; ++j){
                if(isValid(s, j, s.length() - 1 - (i - j))){
                    return s.length()- i;
                }
            }
        }

        return 0;
    }

    private static boolean isValid(String s, int start, int end){
        if(start >= end)
            return false;

        Stack<Character> stack = new Stack<>();
        for(int i = start; i <= end; ++i){
            char c = s.charAt(i);
            switch (c){
                case '(':{
                    stack.push('(');
                } break;
                case ')':{
                    if(stack.empty() || stack.peek().compareTo('(') != 0){
                        return false;
                    } else{
                        stack.pop();
                    }
                } break;
            }
        }

        return stack.empty();
    }
*/
    public static void main(String[] args){
        var ret = new LongestVaildParentheses().longestValidParentheses(")()())");
        System.out.println(ret);
    }
}
