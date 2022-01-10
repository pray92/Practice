package Programmers;

public class ExpressionOfNumber {
    public int solution(int n) {
        int answer = 0;

        for (int left = 1, right = 1; right <= n;) {
            int nSum = getSum(left, right);
            if(nSum < n){
                right++;
            } else if(nSum > n){
                while(nSum > n && left < right){
                    nSum -= left++;
                }
            } else{
                answer++;
                left++;
            }
        }

        return answer;
    }
    private int getSum(int from , int to){
        int ret = 0;
        for(int i = from; i <= to ; ++i)
            ret += i;
        return ret;
    }

    public static void main(String[] args){
        var ret = new ExpressionOfNumber().solution(15);
    }

}
