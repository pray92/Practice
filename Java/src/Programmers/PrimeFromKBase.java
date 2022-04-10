package Programmers;

public class PrimeFromKBase {

    // 1. 0P0처럼 소수 양쪽에 0이 있는 경우
    // 2. P0처럼 소수 오른쪽에만 0이 있고 왼쪽에는 아무것도 없는 경우
    // 3. 0P처럼 소수 왼쪽에만 0이 있고 오른쪽에는 아무것도 없는 경우
    // 4. P처럼 소수 양쪽에 아무것도 없는 경우
    // 5.단, P는 각 자릿수에 0을 포함하지 않는 소수입니다.
    //      예를 들어, 101은 P가 될 수 없습니다.
    public int solution(int n, int k) {
        String strValue = Integer.toString(n, k);
        String[] splitted = strValue.split("0");
        int answer = 0;
        for(String value : splitted){
            if(value.isEmpty()){
                continue;
            }
            
            if(isPrime(Long.parseLong(value))){
                ++answer;
            }
        }
        
        return answer;
    }

    private boolean isPrime(long value){
        if(value <= 1){
            return false;
        }
        
        for(long i = (long)Math.sqrt(value); i >= 2; --i){
            if(value % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println( new PrimeFromKBase().solution(1_000_000, 3));
    }
}
