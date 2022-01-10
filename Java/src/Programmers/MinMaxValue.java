package Programmers;

public class MinMaxValue {

    public String solution(String s) {
        String answer = "";

        String[] strNums = s.split(" ");

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(String strNum : strNums){
            int num = Integer.parseInt(strNum);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        answer = min + " " + max;

        return answer;
    }
}
