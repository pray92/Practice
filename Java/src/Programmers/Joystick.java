package Programmers;

public class Joystick {

    public int solution(String name) {
        int answer = 0;

        // 최대 이동 값은 끝까지 정방향으로 가는 것
        int minMove = name.length() - 1;
        int length = name.length();
        for(int i = 0;  i < length; ++i){
            answer += getMinValue(name.charAt(i));

            int next = i + 1;
            while(next < length && name.charAt(next) == 'A')
                next++;

            minMove = Math.min(minMove, i + i + (length - next));
        }

        answer += minMove;

        return answer;
    }


    private int getMinValue(char alphabet){
        int rot = alphabet - 'A';
        int rotR = 'Z' - alphabet + 1;
        return Math.min(rot, rotR);
    }

    public static void main(String[] args){
        var ret = new Joystick().solution("ZZZZA");
    }
}
