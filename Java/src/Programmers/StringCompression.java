package Programmers;

public class StringCompression {
    public int solution(String s) {
        int answer = 0;

        for(int unit = 1; unit <= s.length(); ++unit){
            int ret = compress(s, unit);
            answer = (ret < answer) ? ret : answer;
        }

        return answer;
    }

    private int compress(String s, int unit){
        StringBuilder sb = new StringBuilder(s);

        return sb.length();
    }
}
