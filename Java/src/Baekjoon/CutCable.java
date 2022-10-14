package Baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CutCable {

    private int getCableMaxLength(int N, int[] cables, int maxCableLength){
        int answer = 0;
        
        int nLeft = 0;
        int nRight = maxCableLength;
        while(nLeft < nRight){
            int offset = (nLeft + nRight) >>> 1;

            int n = 0;
            for(int cable : cables){
                n += (cable / offset);
            }
            
            if(n == N){
                nLeft = offset + 1;
                answer = Math.max(answer, offset);
            } else if(n < N) {
                nRight = offset - 1;
                if(answer >= offset)
                    break;
            } else{
                nLeft = offset + 1;
                answer = Math.max(answer, offset);
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int K = Integer.parseInt(st.nextToken()); 
		int N = Integer.parseInt(st.nextToken()); 
 
		int[] cables = new int[K];

        int maxCableLength = 0;
        for(int i = 0; i < K; ++i){
            cables[i] = Integer.parseInt(br.readLine());
            maxCableLength = Math.max(maxCableLength, cables[i]);
        }

        System.out.println(new CutCable().getCableMaxLength(N, cables, maxCableLength));
    }
}
