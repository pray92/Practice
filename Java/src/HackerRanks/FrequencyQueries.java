package HackerRanks;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class FrequencyQueries {
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        List<Integer> ret = new LinkedList<Integer>();
        
        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(List<Integer> query : queries) {
            int command = query.get(0);
            int number =  query.get(1);

            switch(command) {
                case 1:
                    if(map.containsKey(number)){
                        countMap.put(map.get(number), countMap.getOrDefault(map.get(number), 0) - 1);
                        map.put(number, map.get(number) + 1);   
                        countMap.put(map.get(number), countMap.getOrDefault(map.get(number), 0) + 1);
                    } else {
                        map.put(number, 1);
                        countMap.put(map.get(number), countMap.getOrDefault(map.get(number), 0) + 1);
                    }
                    break;
                case 2:
                    if(map.containsKey(number)){
                        if(map.get(number) <= 0){
                            map.remove(number);
                        } else {
                            countMap.put(map.get(number), countMap.getOrDefault(map.get(number), 0) - 1);
                            map.put(number, map.get(number) - 1);
                            if(0 < map.get(number)){
                                countMap.put(map.get(number), countMap.getOrDefault(map.get(number), 0) + 1);
                            }
                        }
                    }
                    break;
                case 3:
                    ret.add((countMap.containsKey(number) && 0 < countMap.get(number)) ? 1 : 0);
                    break;
            }
        }

        return ret;
    }
}
