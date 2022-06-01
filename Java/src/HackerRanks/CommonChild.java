package HackerRanks;

public class CommonChild {
    public static int commonChild(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s1.length() + 1];
        for(int i = 1; i <= s1.length(); ++i) {
            char ch1 = s1.charAt(i - 1);
            for(int j = 1; j <= s2.length(); ++j) {
                char ch2 = s2.charAt(j - 1);
                if(ch1 == ch2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[s1.length()][s2.length()];
    }

}
