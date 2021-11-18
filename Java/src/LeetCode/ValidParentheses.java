package LeetCode;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); ++i){
            char character = s.charAt(i);
            switch (character){
                case '(':
                case '{':
                case '[':
                {
                    stk.push(character);
                } break;
                case ')':
                    if(stk.empty() || stk.peek() != '(') return false;
                    else stk.pop();
                    break;
                case '}':
                    if(stk.empty() || stk.peek() != '{') return false;
                    else stk.pop();
                    break;
                case ']':
                    if(stk.empty() || stk.peek() != '[') return false;
                    else stk.pop();
                    break;
            }
        }
        return stk.empty();
    }
}
