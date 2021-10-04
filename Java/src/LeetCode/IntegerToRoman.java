package LeetCode;

// 17:18 ~
public class IntegerToRoman {

    public String toStr(int number, int offset,
                        String unit,
                        String unitFive,
                        String unitNine)
    {
        String ret = new String();
        number = (number - (number % offset)) / offset;
        if(number < 5){
            if(number == 4){
                ret = unit + unitFive;
            } else{
                for(int i = 0; i < number; ++i){
                    ret += unit;
                }
            }
        } else{
            if(number == 9){
                ret += unit + unitNine;
            } else{
                ret = unitFive;
                for(int i = 5; i < number; ++i){
                    ret += unit;
                }
            }
        }
        return ret;
    }

    public String intToRoman(int num) {
        String answer = new String();

        // Thousand
        int thousands = num - (num % 1000);
        for(int i = 0; i < thousands / 1000 ; ++i)
            answer += "M";

        // Hundred
        num %= 1000;
        answer += toStr(num, 100, "C", "D", "M");

        // Ten
        num %= 100;
        answer += toStr(num, 10, "X", "L", "C");

        // Digit
        num %= 10;
        answer += toStr(num, 1, "I", "V", "X");

        return answer;
    }

    public static void main(String[] args){
        String answer = new IntegerToRoman().intToRoman(3);
        System.out.println(answer);
        answer = new IntegerToRoman().intToRoman(58);
        System.out.println(answer);
        answer = new IntegerToRoman().intToRoman(1994);
        System.out.println(answer);
    }
}
