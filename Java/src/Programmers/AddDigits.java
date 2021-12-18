package Programmers;

public class AddDigits {
    public int solution(int n) {
        int answer = 0;

        int exp = 1;
        do {
            answer += (n / exp) % 10;
            exp *= 10;
        } while(n % exp != n);

        return answer;
    }
}
