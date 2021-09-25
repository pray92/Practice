package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    /*
    public boolean IsWithoutRepeating(String str){
        boolean[] check = new boolean[128];

        for(int nIndex = 0 ; nIndex < str.length(); ++nIndex){
            char chr = str.charAt(nIndex);
            if(check[chr])
                return false;

            check[chr] = true;
        }
        return true;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();

        int answer = 0;

        for(int nLeft = 0 ; nLeft < s.length(); ++nLeft)
        {
            for(int nRight = s.length() - 1; nRight >= nLeft; --nRight){
                if(answer > nRight - nLeft)
                    break;

                String subStr = s.substring(nLeft, nRight + 1);
                if(IsWithoutRepeating(subStr))
                    answer = subStr.length();
            }
        }

        return answer;
    }
*/

    public int lengthOfLongestSubstring(String s) {
        if(s.isEmpty())
            return 0;

        int answer = 1;
        int left = 0, right = 1;

        Set<Character> set = new HashSet<>();
        while(left < s.length() && right < s.length()){
            if(!set.contains(s.charAt(right)) && s.charAt(left) != s.charAt(right)){
                set.add(s.charAt(right));
                answer = Math.max(answer, right - left + 1);
                ++right;
            }
            else{
                set = new HashSet<>();
                ++left;
                right = left + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters sol = new LongestSubstringWithoutRepeatingCharacters();
        int ans = sol.lengthOfLongestSubstring("bbbbb");
        System.out.println(ans);
        ans = sol.lengthOfLongestSubstring("au");
        System.out.println(ans);
        ans = sol.lengthOfLongestSubstring("pwwkew");
        System.out.println(ans);
    }

}
