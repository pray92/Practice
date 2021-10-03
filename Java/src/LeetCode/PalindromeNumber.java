package LeetCode;

// 9:45
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;

        int tmpX = x, reverseX = 0;
        while(tmpX > 0){
            reverseX = (reverseX * 10) + (tmpX % 10);
            tmpX /= 10;
        }
        return reverseX == x;
    }

    public static void main(String[] args){
        boolean isPalindrome = new PalindromeNumber().isPalindrome(1221);
        isPalindrome = new PalindromeNumber().isPalindrome(12321);
    }

}
