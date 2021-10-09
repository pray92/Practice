package LeetCode;

import java.util.ArrayList;
import java.util.List;

// 15:54 ~
public class LetterCombinationsOfAPhoneNumber {
    List<String> characters = new ArrayList<>(10);

    void dfs(String digits, String msg, List<String> answer){
        if(msg.length() == digits.length()){
            answer.add(msg);
            return;
        }

        int nextDigit = Integer.parseInt("" + digits.charAt(msg.length()));
        String nextDigitChars = characters.get(nextDigit);
        for(int i = 0; i < nextDigitChars.length(); ++i){
            char alphabet = nextDigitChars.charAt(i);
            dfs(digits, msg + alphabet, answer);
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if(digits.length() == 0)
            return answer;

        characters.add("");characters.add("");
        characters.add("abc");
        characters.add("def");
        characters.add("ghi");
        characters.add("jkl");
        characters.add("mno");
        characters.add("pqrs");
        characters.add("tuv");
        characters.add("wxyz");
        dfs(digits, "", answer);
        return answer;
    }

    public static void main(String[] args){
        var answer = new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
        System.out.println(answer.toString());
    }
}
