package HackerRanks;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SherlockAndAnagrams {
    public static int sherlockAndAnagrams(String s) {
    // Write your code here
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(int start = 0; start < s.length(); ++start) {
            for(int end = start + 1; end < s.length() + 1; ++end){
                String key = s.substring(start, end).chars()
                                .sorted()
                                .mapToObj(String::valueOf)
                                .collect(Collectors.joining());
                map.merge(key, 1, (c, d) -> c + 1);
            }
        }
        return map.values().stream().mapToInt(n -> n * (n - 1) / 2).sum();
    }

    public static void main(String[] args) {
        System.out.println(new SherlockAndAnagrams().sherlockAndAnagrams("abba"));
    }
}
