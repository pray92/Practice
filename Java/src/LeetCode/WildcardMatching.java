package LeetCode;

public class WildcardMatching{

    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        // 중복 * 처리
        boolean isFirst = true;
        int patternIndex = 0;
        for(int i = 0; i < pattern.length; ++i){
            if (pattern[i] == '*') {
                if(isFirst){
                    pattern[patternIndex++] = pattern[i];
                    isFirst = false;
                }
            } else{
                pattern[patternIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean[][] dp = new boolean[str.length + 1][patternIndex + 1];
        if(patternIndex > 0 && pattern[0] == '*'){
            dp[0][1] = true;
        }
        dp[0][0] = true;

        for(int i = 1; i < dp.length; ++i){
            for(int j = 1; j < dp[j].length; ++j){
                if(pattern[j - 1] == '?' || pattern[j - 1] == str[i - 1]){
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pattern[j - 1] == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[str.length][patternIndex];
    }


    public static void main(String[] args){
        new WildcardMatching().isMatch("aa", "*");
    }
}