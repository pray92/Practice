package HackerRanks;

import java.util.Collections;
import java.util.List;

public class MarkAndToys {
    
    public static int maximumToys(List<Integer> prices, int k) {
        Collections.sort(prices);
        int ret = 0;

        int sum = 0;
        for(Integer price : prices){
            if(sum + price > k){
                break;
            }

            sum += price;
            ret++;
        }

        return ret;
    }
    
}
