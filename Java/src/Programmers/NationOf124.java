package Programmers;

public class NationOf124 {

    public String solution(int n) {
        StringBuilder answer = new StringBuilder();

        while(n > 0){
            switch(n % 3){
                case 0:{
                    answer.insert(0, 4);
                    n -= 1;
                } break;
                case 1:
                case 2:{
                    answer.insert(0, n % 3);
                } break;
            }

            n /= 3;
        }

        return answer.toString();
    }

    public static void main(String[] args){
        System.out.println(new NationOf124().solution(10));
    }
}
