package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anaMap = new HashMap<String, List<String>>();

        for(String str : strs){
            char[] toChars = str.toCharArray();
            Arrays.sort(toChars);
            String sortedStr = new String(toChars);
            if(anaMap.containsKey(sortedStr)){
                anaMap.get(sortedStr).add(str);
            } else{
                anaMap.put(sortedStr, new ArrayList<>());
                anaMap.get(sortedStr).add(str);
            }
            //System.out.println("Key : " + sortedStr + ", Values : " + anaMap.get(sortedStr).toString());
        }

        List<List<String>> answer = new ArrayList<List<String>>();
        for(var iter : anaMap.entrySet()){
            answer.add(iter.getValue());
        }
        return answer;
    }

    public static void main(String[] args){
        new GroupAnagrams().groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
