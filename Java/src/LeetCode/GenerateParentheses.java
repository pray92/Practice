package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    /* 조건, 대상, 추출 */
    public void generateRecursively(int n, int openCnt, int closeCnt, StringBuilder parentheses, List<String> ret){
        if(openCnt == n && closeCnt == n){
            ret.add(parentheses.toString());
            return;
        }

        if(openCnt < n){
            parentheses.append("(");
            generateRecursively(n, openCnt + 1, closeCnt, parentheses, ret);
            parentheses.setLength(parentheses.length() - 1);
        }

        if(closeCnt < n && openCnt > closeCnt){
            parentheses.append(")");
            generateRecursively(n, openCnt, closeCnt + 1, parentheses, ret);
            parentheses.setLength(parentheses.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        if(n == 1){
            ret.add("()");
            return ret;
        }

        generateRecursively(n, 0, 0, new StringBuilder(), ret);

        return ret;
    }
}
