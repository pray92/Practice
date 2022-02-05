package LeetCode;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if(num1.charAt(0) == '0' || num2.charAt(0) == '0')
            return "0";

        StringBuilder sb = new StringBuilder();

        for(int n2 = num2.length() - 1; n2 >= 0; --n2){
            char digit2 = num2.charAt(n2);
            for(int n1 = num1.length() - 1; n1 >= 0; --n1){
                char digit1 = num1.charAt(n1);
                int radix = (num1.length() - 1 - n1) + (num2.length() - 1 - n2);
                StringBuilder sbMul = multiply(digit1, digit2, radix);
                sb = add(sb, sbMul);
            }
        }

        return sb.toString();
    }

    private StringBuilder multiply(char num1, char num2, int radix){
        StringBuilder sb = new StringBuilder("" + ((num1 - '0') * (num2 - '0')));
        for(int r = 0; r < radix; ++r){
            sb.append('0');
        }
        return sb;
    }

    private StringBuilder add(StringBuilder num1, StringBuilder num2){
        StringBuilder sb = new StringBuilder();
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;

        int rad10 = 0;
        while(i1 >= 0 && i2 >= 0){
            int value = rad10 + (num1.charAt(i1--) - '0') + (num2.charAt(i2--) - '0');
            sb.insert(0, "" + (value % 10));
            rad10 = value / 10;
        }

        while(i1 >= 0){
            int value = rad10 + ((num1.charAt(i1--) - '0'));
            sb.insert(0, "" + (value % 10));
            rad10 = value / 10;
        }

        while(i2 >= 0){
            int value = rad10 + ((num2.charAt(i2--) - '0'));
            sb.insert(0, "" + (value % 10));
            rad10 = value / 10;
        }

        // 마지막에 모두 연산한 이후에 다음 기수가 남아있는 경우
        if(rad10 > 0){
            sb.insert(0,"" + rad10);
        }

        return sb;
    }

    public static void main(String[] args){
        var ret = new MultiplyStrings().multiply("9123", "0");
//        var ret = new MultiplyStrings().add(new StringBuilder("1540"), new StringBuilder("70"));
    }
}
