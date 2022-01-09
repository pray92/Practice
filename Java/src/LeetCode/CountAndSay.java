package LeetCode;

// 15:37
public class CountAndSay {
    public String countAndSay(int n) {
        String[] answers = new String[31];
        answers[1] = "1";
        for(int i = 2; i <= n; ++i){
            answers[i] = getValue(answers[i - 1]);
        }
        return answers[n];
    }

    private String getValue(String prevValue){
        if(prevValue.isEmpty())
            return "";

        StringBuilder ret = new StringBuilder();
        char prevChar = prevValue.charAt(0);
        for(int index = 0, count = 1; index < prevValue.length(); ++index, ++count){
            char curChar = prevValue.charAt(index);
            if(curChar != prevChar){
                ret.append("" + (count - 1) + prevChar);
                if(index >= prevValue.length() - 1) {
                    ret.append("" + 1 + curChar);
                }
                prevChar = curChar;
                count = 1;
            } else{
                if(index >= prevValue.length() - 1){
                    ret.append("" + count + prevChar);
                }
            }
        }

        return ret.toString();
    }

    public static void main(String[] args){
        System.out.println(new CountAndSay().countAndSay(5));
    }

}
