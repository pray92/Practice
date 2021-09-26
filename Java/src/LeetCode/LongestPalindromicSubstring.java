package LeetCode;

// 11:00 ~ 11:09
public class LongestPalindromicSubstring {

    public boolean IsPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            ++left;
            --right;
        }
        return true;
    }

    public String longestPalindrome(String s) {
        if(s.length() <= 1)
            return s;

        String answer = "";
        int left = 0, right = s.length() - 1;
        while(left <= right){
            String subStr = s.substring(left, right + 1);
            if(answer.length() >= subStr.length()) {
                ++left;
                right = s.length() - 1;
                continue;
            }

            if(IsPalindrome(subStr)){
                answer = subStr;
                ++left;
                right = s.length() - 1;
            }
            else{
                --right;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        var answer = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(answer);
        answer = new LongestPalindromicSubstring().longestPalindrome("cbbd");
        System.out.println(answer);
        answer = new LongestPalindromicSubstring().longestPalindrome("a");
        System.out.println(answer);
        answer = new LongestPalindromicSubstring().longestPalindrome("ac");
        System.out.println(answer);
    }

}
