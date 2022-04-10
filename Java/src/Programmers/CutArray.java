package Programmers;

public class CutArray {
    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int)(right - left) + 1];

        int end = (int)(right - left);
        for(int i = 0; i <= end; ++i){
            long div = (left + i) / n;
            long mod = (left + i) % n;
            answer[i] = (int)Math.max(div + 1, mod + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        new CutArray().solution(4, 0, 15);
    }
}
