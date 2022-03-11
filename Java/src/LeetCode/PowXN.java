package LeetCode;

public class PowXN {
    public double myPow(double x, int n) {

        return (0 <= n) ? pow(x, n) : 1 / pow(x, -n);
    }

    public double pow(double x, int n){
        if(n == 1){
            return x;
        } else if(n == 0){
            return 1.0f;
        }
        if(n % 2 == 0){
            return pow(x * x, n >>> 1);
        } 
        return x * pow(x * x, (n - 1) >>> 1);
    }

    public static void main(String[] args){
        System.out.println(new PowXN().myPow(2.1, 3));
        System.out.println(new PowXN().myPow(2, -2));
    }
}
