package HackerRanks;

import java.util.Arrays;

public class GreedyFlorist {
    static int getMinimumCost(int k, int[] c) {
        int answer = 0;
        
        Arrays.sort(c);
        for(int index = c.length - 1; index >= 0; --index) {
            int count = ((c.length - 1 - index) / k) + 1;
            answer += count * c[index];
        }
        
        return answer;
    }   
}
