package LeetCode;

import java.util.Stack;

public class LongestVaildParentheses {
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

    public static void main(String[] args){
        var ret = new LongestVaildParentheses().longestValidParentheses(")()())");
        System.out.println(ret);
    }
}
