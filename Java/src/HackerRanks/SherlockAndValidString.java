package HackerRanks;

public class SherlockAndValidString {
    
    public static String isValid(String s) {
        int[] charCounts = new int ['z' - 'a' + 1];
        for(int index = 0; index < s.length(); ++index) {
            charCounts[s.charAt(index) - 'a']++;
        }
        
        if(isAllSameCount(charCounts)){
            return "YES";
        }
        
        for(int index = 0; index < charCounts.length; ++index) {
            if(0 >= charCounts[index]){
                continue;
            }
            
            charCounts[index]--;
            if(isAllSameCount(charCounts)){
                return "YES";
            }
            charCounts[index]++;
        }
        
        return "NO";
    }
    
    private static boolean isAllSameCount(int[] charCounts) {
        int prevValue = charCounts[0];
        for(int index = 1; index < charCounts.length; ++index) {
            if(0 >= charCounts[index] || prevValue == charCounts[index]){
                continue;
            }
            return false;
        }
        return true;
    }
}
