package LeetCode;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String columnTitle) {
        int answer = 0;

        for(int i = columnTitle.length() - 1, radix = 1; i >= 0; --i, radix *= (int)('Z' - 'A' + 1)){
            answer += (int)(columnTitle.charAt(i) - 'A' + 1) * radix;
        }

        return answer;
    }
}
