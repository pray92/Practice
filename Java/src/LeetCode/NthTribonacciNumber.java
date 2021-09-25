package LeetCode;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if(0 >= n) return 0;
        if(2 >= n) return 1;

        int[] numbers = new int[n + 1];
        {
            numbers[0] = 0;
            numbers[1] = 1;
            numbers[2] = 1;
        }

        for (int nIndex = 3; nIndex <= n; ++nIndex) {
            numbers[nIndex] = numbers[nIndex - 1] + numbers[nIndex - 2] + numbers[nIndex - 3];
        }

        return numbers[n];
    }

    public static void main(String[] args)
    {
        NthTribonacciNumber sol = new NthTribonacciNumber();
        System.out.println(sol.tribonacci(4));
        System.out.println(sol.tribonacci(25));
    }
}
