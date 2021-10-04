package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

// 10:11
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.isEmpty()) return s.isEmpty();

        boolean firstMath = (!s.isEmpty() &&
                            (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

        if(p.length() >= 2 && p.charAt(1) == '*'){
            return (isMatch(s, p.substring(2)) ||
                    (firstMath && isMatch(s.substring(1), p)));
        }
        return (firstMath && isMatch(s.substring(1), p.substring(1)));
    }

    public static void  main(String[] args){

    }
}
