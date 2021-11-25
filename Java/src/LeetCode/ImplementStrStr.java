package LeetCode;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()){
            return 0;
        }

        if(haystack.length() == needle.length()){
            return (haystack.compareTo(needle) == 0) ? 0 : -1;
        }

        for(int i = 0; i < haystack.length() - needle.length() + 1; ++i){
            String subStr = haystack.substring(i, i + needle.length());
            if(subStr.compareTo(needle) == 0)
                return i;
        }
        return -1;
    }
}
