package Programmers;

public class NextLargeNumber {
    public int solution(int n) {
        int answer = n;

        int bitN = Integer.bitCount(n);
        int bit = 0;
        while(bit != bitN){
            bit = Integer.bitCount(++answer);
        }

        return answer;
    }

    public static void main(String[] args){
        new NextLargeNumber().solution(78);
        new NextLargeNumber().solution(16);
        new NextLargeNumber().solution(1);
    }
}
