package Programmers;

import java.util.Map;
import java.util.HashMap;

public class NewsClustering {
    
    private final int MUL_VALUE = 65536;
    
    public int solution(String str1, String str2) {
        
        // 1. 문자열을 2글자 단위로 나눔(특수문자 포함은 무시)
        Map<String, Boolean> keyMap = new HashMap<>();
        Map<String, Integer> str1List = new HashMap<String, Integer>(), str2List = new HashMap<String, Integer>();
        for(int i = 0 ; i < str1.length() - 1; ++i){
            String subStr = str1.substring(i, i + 2);
            subStr = subStr.toLowerCase();
            if(false == Character.isAlphabetic( subStr.charAt(0))  
            || false == Character.isAlphabetic( subStr.charAt(1))){
                continue;
            }

            if(str1List.containsKey(subStr)){
                str1List.replace(subStr, str1List.get(subStr) + 1);
            } else{
                str1List.put(subStr, 1);
            }

            if(false == keyMap.containsKey(subStr)){
                keyMap.put(subStr, true);
            }
        }
        printMap("str1", str1List);
        for(int i = 0 ; i < str2.length() - 1; ++i){
            String subStr = str2.substring(i, i + 2);
            subStr = subStr.toLowerCase();
            if(false == Character.isAlphabetic( subStr.charAt(0))  
            || false == Character.isAlphabetic( subStr.charAt(1))){
                continue;
            }
            
            if(str2List.containsKey(subStr)){
                str2List.replace(subStr, str2List.get(subStr) + 1);
            } else{
                str2List.put(subStr, 1);
            }

            if(false == keyMap.containsKey(subStr)){
                keyMap.put(subStr, true);
            }
        }
        printMap("str2", str2List);
        // 2. 교집합의 개수와 합집합 개수를 구함
        int intersectionCnt = 0, unionCnt = 0;
        for(var iter : keyMap.entrySet()){
            String key = iter.getKey();
            if(str1List.containsKey(key) && str2List.containsKey(key)){
                intersectionCnt += Math.min(str1List.get(key), str2List.get(key));
                unionCnt += Math.max(str1List.get(key), str2List.get(key));
            } else if(str1List.containsKey(key)){
                unionCnt += str1List.get(key);
            } else if(str2List.containsKey(key)){
                unionCnt += str2List.get(key);
            }
        }
        System.out.println("intersection : " + intersectionCnt + ", union :"  + unionCnt);

        // 3. 합집합 수가 0이면 1로 처리
        if(unionCnt == 0){
            return MUL_VALUE;
        }
        
        double answer = intersectionCnt / (double)unionCnt;

        // 5. 65536으로 곱하고 소수 무시(int)
        return (int)(answer * MUL_VALUE);
    }

    private void printMap(String name, Map<String, Integer> map){
        System.out.println("Name : " + name);
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            System.out.println("(" + entry.getKey() + ", " + entry.getValue() + ")");
        }
        System.out.println("----------------------");
    }

    public static void main(String[] args){
        System.out.println( new NewsClustering().solution("AAAA12", "aa1+aa2"));
    }
}
