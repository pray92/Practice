package LeetCode;

// 22:08
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];

        String answer = new String();

        for(int i = 1; i <= strs[0].length(); ++i){

            String offset = strs[0].substring(0, i);

            for(String str : strs){
                if(str.length() + 1 <= i)
                    return answer;

                String subStr = str.substring(0, i);
                if(!offset.matches(subStr))
                    return answer;
            }

            answer = offset;
        }

        return answer.isEmpty() ? strs[0] : answer;
    }

    public static void main(String[] args){
        String ans = new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        ans = new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower","flow","flight"});

    }

}
