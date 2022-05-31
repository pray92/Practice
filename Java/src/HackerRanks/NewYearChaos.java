package HackerRanks;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import Utils.TestUtils;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class NewYearChaos {
    
    private static String TOO_CHAOTIC = "Too chaotic";


    public static void minimumBribes(List<Integer> q) {
        // Write your code here
        int result = 0;
        for(int cnt = 0; cnt < q.size();) {
            boolean isBribed = false;
            for(int index1 = cnt; index1 < q.size() - 1; ++index1) {
                if(q.get(index1) < q.get(index1 + 1)){
                    continue;
                }
                
                isBribed = true;
                
                int offset = 1;
                while((index1 + offset < q.size())
                    && (q.get(index1) > q.get(index1 + offset))){
                    if(2 < offset){
                        System.out.println(TOO_CHAOTIC);
                        return;
                    }
                    ++offset;
                }
                
                int insertValue = q.remove(index1);
                q.add(index1 + offset - 1, insertValue);
                
                result += (offset - 1);
                if(offset - 1 == 1) {
                    ++cnt;
                }
            }
            
            if(false == isBribed){
                break;
            }
        }
        
        System.out.println(result);
    }

    public static void main(String[] args){
        minimumBribes(TestUtils.toList(8, 7, 4, 5));
    }
}
