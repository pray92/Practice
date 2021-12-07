package LeetCode;

import java.util.Stack;

public class LongestVaildParentheses {
    public int longestValidParentheses(String s) {
        int ret = 0, cnt = 0;
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); ++i){
            switch(s.charAt(i)){
                case '(':{
                    stk.push('(');
                    ++cnt;
                } break;
                case ')':{
                    Character top = stk.pop();
                    if(top.compareTo('(') != 0){
                        stk.clear();
                        cnt = 0;
                    } else{
                        if(ret < cnt){
                            ret = cnt;
                        }
                        ++cnt;
                    }
                } break;
            }
        }
        return ret;
    }
}
